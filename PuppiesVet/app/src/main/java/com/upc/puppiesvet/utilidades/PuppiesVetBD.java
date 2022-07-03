package com.upc.puppiesvet.utilidades;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class PuppiesVetBD extends SQLiteOpenHelper {

    public PuppiesVetBD(Context context){
        super(context, "puppiesvet.db",null,1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String queryUsuario ="CREATE TABLE tabla_usuario"+
                "(id_usuario INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "nombres TEXT NOT NULL, "+
                "apellidos TEXT NOT NULL, "+
                "correo TEXT NOT NULL, "+
                "celular INTEGER NOT NULL, "+
                "direccion TEXT NOT NULL, "+
                "password TEXT NOT NULL);";

      /*  String queryMascota ="CREATE TABLE tabla_mascota"+
                "(id_mascota INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "id_propietario INTEGER REFERENCES tabla_usuario (id_usuario), "+
                "nombre_mascota TEXT NOT NULL, "+
                "genero TEXT NOT NULL, "+
                "edad INTEGER NOT NULL);";*/

        db.execSQL(queryUsuario);
/*
        db.execSQL(queryMascota);
*/
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
