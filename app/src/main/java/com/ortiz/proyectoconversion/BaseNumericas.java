package com.ortiz.proyectoconversion;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.ortiz.proyectoconversion.Bases.Conversion;

public class BaseNumericas extends AppCompatActivity {
    private EditText binario, octal, decimal, hexadimal;
    private Button boton;
    private Resources res;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_numericas);
        res=getResources();
        inicializar();
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

    public void inicializar() {
        binario = (EditText) findViewById(R.id.editTextBin);
        octal = (EditText) findViewById(R.id.editTextOct);
        decimal = (EditText) findViewById(R.id.editText3Dec);
        hexadimal = (EditText) findViewById(R.id.editTextHex);
        boton = (Button) findViewById(R.id.buttonConrv);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (!(binario.getText().toString().isEmpty() || binario.getText().toString().equals(""))) {
                        publicarRespuesta(Conversion.Conversion(binario.getText().toString(), 2));

                    } else if (!(octal.getText().toString().isEmpty() || octal.getText().toString().equals(""))) {
                        publicarRespuesta(Conversion.Conversion(octal.getText().toString(), 8));

                    } else if (!(decimal.getText().toString().isEmpty() || decimal.getText().toString().equals(""))) {
                        publicarRespuesta(Conversion.Conversion(decimal.getText().toString(), 10));

                    } else if (!(hexadimal.getText().toString().isEmpty() || hexadimal.getText().toString().equals(""))) {
                        publicarRespuesta(Conversion.Conversion(hexadimal.getText().toString(), 16));

                    } else {
                        Mostrarmensaje(res.getString(R.string.Campo_obligatorio_numero));
                    }
                }catch (Exception ex)
                {
Mostrarmensaje(res.getString(R.string.No_valido));
                }

            }
        });
    }
    private void Mostrarmensaje(String mensaje)
    {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_base_numericas, menu);
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

    public void publicarRespuesta(String[] respuestas) {
        binario.setText(respuestas[0]);
        octal.setText(respuestas[1]);
        decimal.setText(respuestas[2]);
        hexadimal.setText(respuestas[3]);

    }
}
