package com.ortiz.proyectoconversion;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.ortiz.proyectoconversion.Notas.Nota;

public class NotasActivudad extends AppCompatActivity {

    private Nota notas[];
    private EditText notaunica;
    private EditText porcantajeunico;
    private EditText porcentaje1;
    private EditText nota1;
    private TextView salida;
    private Resources recursos;
    private int Numeronotas;
    private int Ninicialnota;
    private EditText nnotas;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas_activudad);
        inicializar();
        mAdView = (AdView) findViewById(R.id.BannerInicial);
        // Create an ad request. Check your logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .setGender(AdRequest.GENDER_MALE)

                .build();

        // Start loading the ad in the background.
        mAdView.loadAd(adRequest);
    }

    public void inicializar() {
        nnotas = (EditText) findViewById(R.id.editTextnnotas);
        notaunica = (EditText) findViewById(R.id.editTextNota);
        porcantajeunico = (EditText) findViewById(R.id.editTextPorcentaje);
        salida = (TextView) findViewById(R.id.textViewSalida);
        porcentaje1 = (EditText) findViewById(R.id.editTextPocentaje1);
        nota1 = (EditText) findViewById(R.id.editTextNota1);
        recursos = getResources();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_notas_activudad, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void crearNotas(int cantidad) {
        notas = new Nota[cantidad];
    }

    public double CalcularNecesario() {
        double acomulado = 0;
        double porcentajeacomulado = 0;
        for (Nota nota : notas) {
            porcentajeacomulado += nota.procentaje;
            acomulado += nota.Valor();
        }
        double nesecito = (3 - acomulado) * (100 - porcentajeacomulado);
        return nesecito;
    }

    public void CalcularNota(View view) {
        try {
            double nota = (Double.parseDouble(notaunica.getText().toString()));
            double porcentaje = (Double.parseDouble(porcantajeunico.getText().toString()));
           // Toast.makeText(this,nota+"/"+porcentaje,Toast.LENGTH_LONG).show();

            if (nota > 5 || porcentaje>=100) {
                throw new java.lang.NumberFormatException();
            }
           // Toast.makeText(this,nota+"/"+porcentaje,Toast.LENGTH_LONG).show();
           salida.setText(recursos.getString(R.string.nesecitas) + " " + calcular(porcentaje, nota));


        } catch (Exception ex) {
            Toast.makeText(this, recursos.getString(R.string.digita_error), Toast.LENGTH_SHORT).show();
        }
    }

    public double calcular(double porcentaje, double nota) {
        double need=(3-nota)* (100 - porcentaje);
        if(need<=0){need=0;}
        return need;
        //
    }

    public void iniciarConteo(View view) {
        try {
            Numeronotas = Integer.parseInt(nnotas.getText().toString());
            notas = new Nota[Numeronotas];
            Ninicialnota = 0;
            Toast.makeText(this, recursos.getString(R.string.digita_nota) + " " + (Ninicialnota + 1), Toast.LENGTH_SHORT).show();

        } catch (Exception ex) {
            Toast.makeText(this, recursos.getString(R.string.Campo_no_nulo), Toast.LENGTH_SHORT).show();
        }
    }

    public void RegistrarNota(View view) {
        try {


            notas[Ninicialnota] = new Nota(Double.parseDouble(porcentaje1.getText().toString()),
                    Double.parseDouble(nota1.getText().toString()));

                    if(notas[Ninicialnota].valor>5)
                    {
                        throw new java.lang.NumberFormatException();
                    }Ninicialnota++;
            Toast.makeText(this, recursos.getString(R.string.digita_nota) + " " + (Ninicialnota + 1), Toast.LENGTH_SHORT).show();

            if (Ninicialnota >= notas.length) {
                salida.setText(recursos.getString(R.string.nesecitas) + " " + CalcularNecesario());
                Ninicialnota = 0;
                nnotas.setText("");
            }

        } catch (Exception ex) {
            Toast.makeText(this, recursos.getString(R.string.No_valido), Toast.LENGTH_SHORT).show();
        }

    }
}
