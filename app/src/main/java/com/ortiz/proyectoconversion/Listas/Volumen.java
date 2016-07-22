package com.ortiz.proyectoconversion.Listas;

/**
 * Created by Daniel on 19/11/2015.
 */
public enum Volumen {
    Metro(1,1000,33814,264.172,67628,"Metro cubico","m^3"),
    Onza(0.000029574,0.0295735,1,0.0078125,2,"Onza","oz"),
    Galon(0.00378541,3.78541,128,1,256,"Galon","gal"),
    Cucharada(0.000014787,0.0147868,0.5,0.00390625,1,"Cucharada","Cucharda"),
    Litro(0.001,1,33.814,0.264172,67.628,"Litro","L");
 private final double metro;
    private final double litro;
    private final double onza;
    private final double galon;
    private final double cucharada;
    private final String nombre;
    private final String denominacion;
    private Volumen(double metro,double litro,double onza,double galon,double cucharada,String nombre,String denominacion){
        this.metro=metro;
        this.litro=litro;
        this.onza=onza;
        this.galon=galon;
        this.cucharada=cucharada;
        this.nombre=nombre;
        this.denominacion=denominacion;
    }
    public static double convertir(Volumen de, Volumen a,double cantidad)
    {
        switch (a){
            case Metro:
                return cantidad*de.metro;
            case Litro:
                return cantidad*de.litro;
            case Onza:
                return cantidad*de.onza;
            case Galon:
                return cantidad*de.galon;
            case Cucharada:
                return cantidad*de.cucharada;
            default: return 0;
        }
    }

    @Override
    public String toString() {
        return denominacion;
    }
}
