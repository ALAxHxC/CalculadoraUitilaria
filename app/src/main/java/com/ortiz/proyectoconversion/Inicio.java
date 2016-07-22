package com.ortiz.proyectoconversion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

public class Inicio extends AppCompatActivity {
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        AdView mAdView = (AdView) findViewById(R.id.BannerInicial);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_inicio, menu);
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

    public void EnviarConversion(View view) {
        Intent intent = new Intent(this, Principal.class);
        startActivity(intent);
    }

    public void EnviarEcuacionCuadratica(View view) {
        Intent intent = new Intent(this, EcuacionCuadratica.class);
        startActivity(intent);
    }

    public void EnviarNotas(View view) {
        Intent intent = new Intent(this, NotasActivudad.class);
        startActivity(intent);
    }

    public void EnviarBases(View view) {
        Intent intent = new Intent(this, BaseNumericas.class);
        startActivity(intent);
    }

    public void EnviarLineal(View view) {
        Intent intent = new Intent(this, Ecuaciones_lineales.class);
        startActivity(intent);
    }
}
