package com.upc.puppiesvet.utilidades;

public class Utilidades {

    //Constantes campos tabla Usuario
    public static final String TABLA_USUARIO="usuario";
    public static final String CAMPO_ID="id_usuario";
    public static final String CAMPO_NOMBRES="nombres";
    public static final String CAMPO_APELLIDOS="apellidos";
    public static final String CAMPO_CORREO="correo";
    public static final String CAMPO_CELULAR="celular";
    public static final String CAMPO_DIRECCION="direccion";
    public static final String CAMPO_PASSWORD="password";

    public static final String CREAR_TABLA_USUARIO="CREATE TABLE "+
            ""+ TABLA_USUARIO+" ("+CAMPO_ID+" "+"INTEGER PRIMARY KEY AUTOINCREMENT, "+
            CAMPO_ID+" "+"TEXT, "+
            CAMPO_NOMBRES+" "+"TEXT, "+
            CAMPO_APELLIDOS+" "+"TEXT, " +
            CAMPO_CORREO+" "+"TEXT, " +
            CAMPO_CELULAR+" "+"TEXT, " +
            CAMPO_DIRECCION+" "+"TEXT, " +
            CAMPO_PASSWORD+" "+"TEXT)";

    //Constantes campos tabla Mascota
    public static final String TABLA_MASCOTA="mascota";
    public static final String CAMPO_ID_MASCOTA="id_ascota";
    public static final String CAMPO_ID_PROPIETARIO="id_propietario";
    public static final String CAMPO_NOMBRE_MASCOTA="nombre_mascota";
    public static final String CAMPO_GENERO="genero";
    public static final String CAMPO_EDAD="edad";

    public static final String CREAR_TABLA_MASCOTA="CREATE TABLE "+
            ""+ TABLA_MASCOTA+" ("+CAMPO_ID_MASCOTA+" "+"INTEGER PRIMARY KEY AUTOINCREMENT, "+
            CAMPO_ID_PROPIETARIO+" "+"INTEGER REFERENCES "+" "+TABLA_USUARIO+"("+CAMPO_ID+"),"+
            CAMPO_NOMBRE_MASCOTA+" "+"TEXT, "+
            CAMPO_GENERO+" "+"TEXT, " +
            CAMPO_EDAD+" "+"INTEGER)";

}
