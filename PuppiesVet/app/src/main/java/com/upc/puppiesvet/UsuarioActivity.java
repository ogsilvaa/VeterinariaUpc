package com.upc.puppiesvet;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.upc.puppiesvet.entidad.Usuario;

import java.io.File;
import java.util.UUID;


public class UsuarioActivity extends AppCompatActivity {

    Button btn_RegistrarUsuario;
    EditText et_Nombres, et_Apellidos, et_Correo, et_Celular, et_Direccion, et_PasswordPerfil;
    ImageView imgFoto;

    FirebaseDatabase database;
    DatabaseReference reference;
    Usuario usuario;

    private final String CARPETA_RAIZ = "misImagenesPrueba/";
    private final String RUTA_IMAGEN = "misFotos";
    private final int COD_SELECTION = 10;
    private final int COD_PHOTO = 20;
    private String path = "";

    private String TomarFoto = "Tomar Foto";
    private String CargarImagen = "Cargar Imagen";
    private String Cancelar = "Cancelar";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);

        asignarReferencias();
        inicializarFirebase();

    }

    private void asignarReferencias() {
        et_Nombres = findViewById(R.id.et_Nombres);
        et_Apellidos = findViewById(R.id.et_Apellidos);
        et_Correo = findViewById(R.id.et_Correo);
        et_Celular = findViewById(R.id.et_Celular);
        et_Direccion = findViewById(R.id.et_Direccion);
        et_PasswordPerfil = findViewById(R.id.et_PasswordPerfil);

        btn_RegistrarUsuario = findViewById(R.id.btn_RegistrarUsuario);
        btn_RegistrarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (capturarDatos()) {
                    reference.child("Usuario").child(usuario.getIdUsuario()).setValue(usuario);
                    AlertDialog.Builder ventana = new AlertDialog.Builder(UsuarioActivity.this);
                    ventana.setTitle("Usuario registrado");
                    ventana.setMessage("Se ha registrado al usuario.");
                    ventana.setPositiveButton("OK", null);
                    ventana.create().show();
                }
            }
        });

        imgFoto = findViewById(R.id.imgFoto);
        imgFoto.setOnClickListener(v -> {
            cargarImagen();
        });

        et_Direccion.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_UP) {
                if (event.getRawX() >= (et_Direccion.getRight() - et_Direccion.getCompoundDrawables()[2].getBounds().width())) {
                    Intent intent = new Intent(this, MapsActivity.class);
                    startActivity(intent);
                    return true;
                }
            }
            return false;
        });

    }

    private void cargarImagen() {
        final CharSequence[] opciones = {CargarImagen, Cancelar};
        final AlertDialog.Builder alertOpciones = new AlertDialog.Builder(this);
        alertOpciones.setTitle("Seleccione una Opción");
        alertOpciones.setItems(opciones, (dialog, i) -> {
            //Tomar Foto
            if (opciones[i].equals(TomarFoto)) {
                tomarFotografia();
                //Cargar imagen
            } else if (opciones[i].equals(CargarImagen)) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                intent.setType("image/");
                startActivityForResult(intent.createChooser(intent, "Seleccione la Aplicación"), COD_SELECTION);
                // Cancelar
            } else {
                dialog.dismiss();
            }
        });
        alertOpciones.show();
    }

    private void tomarFotografia() {
        String nameFile = "";
        File file = new File(Environment.getExternalStorageDirectory(), RUTA_IMAGEN);
        boolean isCreate = file.exists();

        if (!isCreate) {
            isCreate = file.mkdirs();
        }
        if (isCreate) {
            nameFile = System.currentTimeMillis() / 100 + ".jpg";
        }

        path = Environment.getExternalStorageDirectory() + File.separator + RUTA_IMAGEN + File.separator + nameFile;
        File imagen = new File(path);
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(imagen));
        //startActivityForResult(intent, COD_PHOTO);
        //launcher.launch(intent);

    }

    /*ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == COD_PHOTO) {
                        Intent data = result.getData();
                        Log.i("Selection Mode", "Mode: photo");
                        MediaScannerConnection.scanFile(UsuarioActivity.this, new String[]{path}, null,
                                new MediaScannerConnection.OnScanCompletedListener() {
                                    @Override
                                    public void onScanCompleted(String path, Uri uri) {
                                        Log.i("Image path", "Path: " + path);
                                    }
                                });

                        Bitmap bitmap = BitmapFactory.decodeFile(path);
                        imgFoto.setImageBitmap(bitmap);
                    }
                }
            }
    );*/

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case COD_SELECTION:
                    Uri myPath = data.getData();
                    imgFoto.setImageURI(myPath);
                    break;
                case COD_PHOTO:
                    Log.i("Selection Mode", "Mode: photo");
                    MediaScannerConnection.scanFile(this, new String[]{path}, null,
                            new MediaScannerConnection.OnScanCompletedListener() {
                                @Override
                                public void onScanCompleted(String path, Uri uri) {
                                    Log.i("Image path", "Path: " + path);
                                }
                            });

                    Bitmap bitmap = BitmapFactory.decodeFile(path);
                    imgFoto.setImageBitmap(bitmap);
                    break;
                default:
                    break;
            }
            Uri path = data.getData();
            imgFoto.setImageURI(path);
        }
    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(this);
        database = FirebaseDatabase.getInstance();
        reference = database.getReference();
    }

    private boolean capturarDatos() {
        String nombres = et_Nombres.getText().toString();
        String apellidos = et_Apellidos.getText().toString();
        String correo = et_Correo.getText().toString();
        String celular = et_Celular.getText().toString();
        String direccion = et_Direccion.getText().toString();
        String password = et_PasswordPerfil.getText().toString();

        boolean valida = true;

        if (nombres.equals("")) {
            et_Nombres.setError("Nombres obligatorios");
            valida = false;
        }

        if (apellidos.equals("")) {
            et_Apellidos.setError("Apellidos obligatorios");
            valida = false;
        }

        if (correo.equals("")) {
            et_Correo.setError("Correo obligatorio");
            valida = false;
        }

        if (celular.equals("")) {
            et_Celular.setError("Celular obligatorio");
            valida = false;
        }

        if (direccion.equals("")) {
            et_Direccion.setError("Dirección obligatoria");
            valida = false;
        }

        if (et_PasswordPerfil.equals("")) {
            et_Nombres.setError("Contraseña obligatoria");
            valida = false;
        }

        if (valida) {
            usuario = new Usuario();
            usuario.setIdUsuario(UUID.randomUUID().toString());
            usuario.setNombres(nombres);
            usuario.setApellidos(apellidos);
            usuario.setCorreo(correo);
            usuario.setCelular(celular);
            usuario.setDireccion(direccion);
            usuario.setPassword(password);
        }
        return valida;

    }

}