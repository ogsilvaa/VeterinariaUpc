package com.upc.puppiesvet;

import java.util.List;

public class serviciosList {
    private String nom_servicio;
    private int imgResource;

    public serviciosList(String nom_servicio,int imgResource){
        this.nom_servicio = nom_servicio;
        this.imgResource = imgResource;
    }


    public String getNom_servicio(){
        return nom_servicio;
    }

    public int getImgResource(){
        return imgResource;
    }
}
