package com.upc.puppiesvet.entidad;

public class Mascota {

    private Integer idMascota;
    private Integer idUsuario;
    private String nombre;
    private String tipo;
    private String genero;
    private Integer edad;

    public Mascota(Integer idMascota, Integer idUsuario, String nombre, String tipo, String genero, Integer edad) {
        this.idMascota = idMascota;
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.tipo = tipo;
        this.genero = genero;
        this.edad = edad;
    }

    public Mascota(Integer idUsuario, String nombre, String tipo, String genero, Integer edad) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.tipo = tipo;
        this.genero = genero;
        this.edad = edad;
    }

    public Integer getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(Integer idMascota) {
        this.idMascota = idMascota;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
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

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }
}
