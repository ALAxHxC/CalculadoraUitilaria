package com.ortiz.proyectoconversion.Listas;

/**
 * Created by Daniel on 17/11/2015.
 */
public enum Longitud {

    Metro("Metro", 1, 0.000621371, 1.09361, 3.28084, 39.37008, 0.000539957, "m"),
    Milla("Milla", 1609.34, 1, 1759.99562552, 5280, 63360, 0.868976, "milla"),
    Yarda("Yarda", 0.9144, 0.000568182, 1, 3, 36, 0.000493737, "yd"),
    Pie("Pie", 0.3048, 0.000189394, 0.333333, 1, 12, 0.000164579, "ft"),
    Pulgada("Pulgada", 0.0254, 0.000015783, 0.0277778, 0.0833333, 1, 0.000013715, "in"),
    MillaNautica("MillaNautica", 1852, 1.15078, 2025.37, 6076.12, 72913.4, 1, "Nudos");

    public final String nombre;
    public final double metro;
    public final double milla;
    public final double yarda;
    public final double pie;
    public final double pulgada;
    public final double millanautica;
    //Exponentes;

    public final String nominacion;

    private Longitud(String nombre, double metro, double milla, double yarda, double pie, double pulgada, double millanautica, String nom) {
        this.nombre = nombre;
        this.metro = metro;
        this.milla = milla;
        this.yarda = yarda;
        this.pie = pie;
        this.pulgada = pulgada;
        this.millanautica = millanautica;
        this.nominacion = nom;


    }

    public static double conversion(Longitud de, Longitud a, double cantidad) {

        switch (a) {
            case Metro:
                return cantidad * de.metro;

            case Milla:
                return cantidad * de.milla;

            case Yarda:
                return cantidad * de.yarda;

            case Pie:
                return cantidad * de.pie;

            case Pulgada:
                return cantidad * de.pulgada;

            case MillaNautica:
                return cantidad * de.millanautica;

            default:
                return 0;
        }

    }

    @Override
    public String toString() {
        return nominacion;
    }
}

