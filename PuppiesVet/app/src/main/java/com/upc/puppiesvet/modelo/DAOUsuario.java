package com.upc.puppiesvet.modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.upc.puppiesvet.utilidades.PuppiesVetBD;

public class DAOUsuario {
    PuppiesVetBD puppiesVetBD;
    SQLiteDatabase db;

    public DAOUsuario(Context context){
        puppiesVetBD = new PuppiesVetBD(context);
        db = puppiesVetBD.getWritableDatabase();
    }


    public String registrarUsuario(PuppiesVetBD puppiesVetBD){
        String respuesta="";
        try{
            ContentValues valores = new ContentValues();
/*
            valores.put("nombres",);
*/
        }catch (Exception e){
            Log.d("===>",e.getMessage());
        }
        return respuesta;

        /*"nombres TEXT NOT NULL,"+
                "apellidos TEXT NOT NULL,"+
                "correo TEXT NOT NULL,"+
                "celular INTEGER NOT NULL,"+
                "direccion TEXT NOT NULL,"+
                "password TEXT NOT NULL);";*/

    }

    public void abrirBD(){
        db= puppiesVetBD.getWritableDatabase();
    }


}
