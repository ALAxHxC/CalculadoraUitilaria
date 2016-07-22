package com.ortiz.proyectoconversion.Notas;

/**
 * Created by Daniel on 24/11/2015.
 */
public class Nota {
    public final double procentaje;
    public final double valor;

    public Nota(double porcentaje, double valor) {
        this.procentaje = porcentaje;
        this.valor = valor;
    }

    public double Valor() {
        return valor * (procentaje / 100);

    }
}
