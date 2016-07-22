package com.ortiz.proyectoconversion.Listas;
/**
 * Created by Daniel on 17/11/2015.
 */
public enum Bytes {

    Bit("Bit", "b", -1),
    Byte("Byte", "B", 0),
    Kilo("Kilo", "KB", 1),
    Mega("MegaByte", "MB", 2),
    Giga("GigaByte", "GB", 3),
    Tera("TeraByte", "TB", 4),
    Peta("PetaBytes", "PB", 5);

    public final String nombre;
    public static final double sub = 1024;
    public String nominacion;
    public final double orden;

    Bytes(String nombre, String nominacion, int orden) {
        this.nombre = nombre;

        this.nominacion = nominacion;
        this.orden = orden;
    }

    public static final double convertir(Bytes de, Bytes a, double cantidad) {
        if (de.nombre.equals(a.nombre)) {
            return cantidad;
        } else if (a.nombre.equals(Bit.nombre)) {
            return ((cantidad * 8) * (Math.pow(sub, de.orden)));
        } else if (de.nombre.equals(Bit.nombre)) {
            return ((cantidad * 1 / 8) * (Math.pow(sub, -1 * a.orden)));
        } else if (de.nombre.equalsIgnoreCase(a.nombre)) {
            return (cantidad);
        } else if (de.orden > a.orden) {
            return (cantidad * Math.pow(sub, de.orden - a.orden));
        } else {
            return (cantidad / Math.pow(sub, a.orden - de.orden));
        }
    }

    @Override
    public String toString() {
        return nominacion;
    }
}
