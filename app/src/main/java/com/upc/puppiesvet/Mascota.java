package com.upc.puppiesvet;

public class Mascota {

    private String id;
    private String nombre;
    private String tipo;
    private String genero;
    private String edad;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public Mascota(String id, String nombre, String tipo, String genero, String edad) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.genero = genero;
        this.edad = edad;
    }

    public Mascota(String nombre, String tipo, String genero, String edad) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.genero = genero;
        this.edad = edad;
    }
}
