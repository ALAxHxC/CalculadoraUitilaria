package com.ortiz.proyectoconversion.Listas;

/**
 * Created by Daniel on 17/11/2015.
 */
public enum Opciones {
    Bytes("Bytes"),
    Distancia("Longitud"),
    Volumen("Volumen"),

    Velocidad("Velocidad");
    public final String nombre;
    Opciones(String nom)
    {
        nombre=nom;
    }
    @Override public String toString(){
        return nombre;
    }

}
