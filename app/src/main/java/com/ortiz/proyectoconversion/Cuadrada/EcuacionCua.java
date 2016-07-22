package com.ortiz.proyectoconversion.Cuadrada;

/**
 * Created by Daniel on 23/11/2015.
 */
public class EcuacionCua {
    public static final double[] Valores(double a,double b,double c)
    {
        double res[]=new double[2];
        res[0]=((-1*b)+Math.sqrt((b*b)-(4*a*c)))/2*a;
        res[1]=((-1*b)-Math.sqrt((b*b)-(4*a*c)))/2*a;
        return res;
    }
}
