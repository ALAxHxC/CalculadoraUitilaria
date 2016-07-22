package com.ortiz.proyectoconversion.Bases;

/**
 * Created by Daniel on 03/12/2015.
 */
public class Conversion {
    public static String[] Conversion(String numero,int base)
    {
        int dec= Integer.parseInt(numero, base);
        String bin=Integer.toBinaryString(dec);
        String oct=Integer.toOctalString(dec);
        String hexa=Integer.toHexString(dec);
        String dec1=""+dec;
        String bases[]={bin,oct,dec1,hexa};
        return bases;
    }
}
