package com.ortiz.proyectoconversion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.ortiz.proyectoconversion.Listas.*;


import java.util.Set;

public class Principal extends AppCompatActivity {
    private Spinner Opcciones;
    private ArrayAdapter AdaptadorLongitud;
    private ArrayAdapter AdaptadorVelocidad;
    private ArrayAdapter AdaptadorVolumen;
    private ArrayAdapter AdaptadorBytes;
    private Spinner de;
    private Spinner a;
    private EditText salida;
    private EditText entrada;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Opcciones = (Spinner) findViewById(R.id.spinnerOpciones);
        inicializarOpcciones();
        inicializarVariables();
        mAdView = (AdView) findViewById(R.id.BannerInicial);
        // Create an ad request. Check your logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .setGender(AdRequest.GENDER_UNKNOWN)
                .build();
        // Start loading the ad in the background.
        mAdView.loadAd(adRequest);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        menu.clear();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        return super.onOptionsItemSelected(item);
    }

    private void inicializarVariables() {
        salida = (EditText) findViewById(R.id.editTextSalida);
        entrada = (EditText) findViewById(R.id.editTextEntrada);
        de = (Spinner) findViewById(R.id.spinnerDe);
        a = (Spinner) findViewById(R.id.spinnerA);
    }

    private void inicializarOpcciones() {
        Opcciones.setAdapter(new ArrayAdapter<Opciones>(this,  R.layout.spinner_item,R.id.textview, Opciones.values()));
        AdaptadorBytes = new ArrayAdapter<Bytes>(this, R.layout.spinner_item,R.id.textview, Bytes.values());
        AdaptadorLongitud = new ArrayAdapter<Longitud>(this, R.layout.spinner_item,R.id.textview, Longitud.values());
        AdaptadorVelocidad = new ArrayAdapter<Velocidad>(this, R.layout.spinner_item,R.id.textview, Velocidad.values());
        AdaptadorVolumen = new ArrayAdapter<Volumen>(this,R.layout.spinner_item,R.id.textview, Volumen.values());
        Opcciones.setOnItemSelectedListener(new SpinnerActivity());
    }

    private void SetValores(ArrayAdapter<Enum> ad) {
        a.setAdapter(ad);
        de.setAdapter(ad);
    }

    private void Seleccion(Opciones op) {
        switch (op) {
            case Bytes:
                SetValores(AdaptadorBytes);
                break;
            case Velocidad:
                SetValores(AdaptadorVelocidad);
                break;
            case Distancia:
                SetValores(AdaptadorLongitud);
                break;
            case Volumen:
                SetValores(AdaptadorVolumen);
                break;
        }
    }

    private void Conversion(Opciones op) {
        switch (op) {
            case Bytes:
                SetValores(AdaptadorBytes);
                break;
            case Velocidad:
                SetValores(AdaptadorVelocidad);
                break;
            case Distancia:
                SetValores(AdaptadorLongitud);
                break;
            case Volumen:
                SetValores(AdaptadorVolumen);
                break;
        }
    }

    public void Conversion(View view) {
        Opciones op = (Opciones) Opcciones.getSelectedItem();

        double in = Double.parseDouble(entrada.getText().toString());
        double out = 0;
        switch (op) {
            case Bytes:
                Bytes deC = (Bytes) de.getSelectedItem();
                Bytes aC = (Bytes) a.getSelectedItem();
                out = Bytes.convertir(deC, aC, in);

                break;
            case Velocidad:
                Velocidad dC = (Velocidad) de.getSelectedItem();
                Velocidad sC = (Velocidad) a.getSelectedItem();
                out = Velocidad.Conversion(dC, sC, in);

                break;
            case Distancia:
                Longitud DC = (Longitud) de.getSelectedItem();
                Longitud SC = (Longitud) a.getSelectedItem();
                out = Longitud.conversion(DC, SC, in);
                break;
            case Volumen:
                Volumen IC = (Volumen) de.getSelectedItem();
                Volumen FC = (Volumen) a.getSelectedItem();
                out = Volumen.convertir(IC, FC, in);
                break;
            default:
                Mensaje("Seleccione una opccion");
        }
        salida.setText("" + out);
    }


    private void Mensaje(Object mensaje) {
        Toast toast = Toast.makeText(this, mensaje.toString(), Toast.LENGTH_SHORT);
        toast.show();
    }

    //Spinner
    private class SpinnerActivity implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view,
                                   int pos, long id) {

            Opciones op = (Opciones) Opcciones.getSelectedItem();
            Seleccion(op);
        }

        public void onNothingSelected(AdapterView<?> parent) {
            // Another interface callback
        }
    }

}
