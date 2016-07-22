package com.ortiz.proyectoconversion.Listas;
/**
 * Created by Daniel on 20/11/2015.
 */
public enum Velocidad {
    Metros(1, 3.6, 1.94384, 3.28084, 2.23694, "Metros por segundo", "m/s"),
    Kilometors(0.277778, 1, 0.539957, 0.911344, 0.621371, "Kilometros por hora", "k/h"),
    Nudos(0.514444, 1.852, 1, 1.68781, 1.15078, "Nudos", "knots"),
    Pies(0.3048, 1.09728, 0.592484, 1, 0.681818, "Pies por segundo", "ft/s"),
    Millas(0.44704, 1.60934, 0.868976, 1.46667, 1, "Millas por hora", "mph");
    private final double metrossegundo;
    private final double kilometroshora;
    private final double nudos;
    private final double piesporsegundo;
    private final double millasporhora;
    private final String nombre;
    private final String nominacion;

    private Velocidad(double metrossegundo, double kilometroshora, double nudos, double piesporsegundo, double millasporhora, String nombre, String nominacion) {
        this.metrossegundo = metrossegundo;
        this.kilometroshora = kilometroshora;
        this.nudos = nudos;
        this.piesporsegundo = piesporsegundo;
        this.millasporhora = millasporhora;
        this.nombre = nombre;
        this.nominacion = nominacion;
    }

    public static double Conversion(Velocidad de, Velocidad a, double cantidad) {
        switch (a) {
            case Metros:
                return de.metrossegundo * cantidad;
            case Kilometors:
                return de.kilometroshora * cantidad;
            case Nudos:
                return de.nudos;
            case Pies:
                return de.piesporsegundo * cantidad;
            case Millas:
                return de.millasporhora * cantidad;
            default:
                return 0;
        }
    }

    @Override
    public String toString() {
        return nominacion;
    }
}
