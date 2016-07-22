package com.ortiz.proyectoconversion;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.ortiz.proyectoconversion.Cuadrada.EcuacionCua;

public class EcuacionCuadratica extends AppCompatActivity {
    private EditText a;
    private EditText b;
    private EditText c;
    private EditText x1;
    private EditText x2;
    private Resources recursos;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecuacion_cuadratica);
        inicializarVariables();
        mAdView = (AdView) findViewById(R.id.BannerInicial);
        // Create an ad request. Check your logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .setGender(AdRequest.GENDER_FEMALE)

                .build();

        // Start loading the ad in the background.
        mAdView.loadAd(adRequest);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ecuacion_cuadratica, menu);
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

    private void inicializarVariables() {
        a = (EditText) findViewById(R.id.editTextA);
        b = (EditText) findViewById(R.id.editTextB);
        c = (EditText) findViewById(R.id.editTextC);
        x1 = (EditText) findViewById(R.id.editTextSX1);
        x2 = (EditText) findViewById(R.id.editTextSX2);

        recursos = getResources();
    }

    public void Calcular(View view) {
        try {
            double a1 = Double.parseDouble(a.getText().toString());
            double b1 = Double.parseDouble(b.getText().toString());
            double c1 = Double.parseDouble(c.getText().toString());
            double respuestas[] = EcuacionCua.Valores(a1, b1, c1);
            if (Double.isNaN(respuestas[0]) && Double.isNaN(respuestas[1])) {
                Toast.makeText(this, recursos.getString(R.string.no_tiene_solucion), Toast.LENGTH_SHORT).show();
            } else if (Double.isNaN(respuestas[0])) {
                x1.setText(recursos.getString(R.string.no_tiene_solucion));
                x2.setText("" + respuestas[1]);
            } else if (Double.isNaN(respuestas[1])) {
                x2.setText(recursos.getString(R.string.no_tiene_solucion));
                x1.setText("" + respuestas[0]);
            } else {
                x1.setText("" + respuestas[0]);
                x2.setText("" + respuestas[1]);
            }

        } catch (Exception ex) {
            Toast.makeText(this, recursos.getString(R.string.numeros), Toast.LENGTH_SHORT).show();

        }
    }
}
