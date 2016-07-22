package com.ortiz.proyectoconversion;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.text.DecimalFormat;

public class Ecuaciones_lineales extends AppCompatActivity {
    private EditText Nvariables;
    private Resources res;
    private LinearLayout lineal[];
    private Button iniciar;
    private Button resolver;
    private EditText x1, x2, x3;
    private EditText y1, y2, y3;
    private EditText z1, z2, z3;
    private EditText r1, r2, r3;
    private TextView Y1, Y2, Y3;
    private TextView Z1, Z2, Z3;
    private TextView Y, X, Z;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecuaciones_lineales);
        inicializarX();
        inicializarY();
        inicializarZ();
        inicializarR();
        InicializarRs();
        inicializar();
        inicializarBoton();
        mAdView = (AdView) findViewById(R.id.BannerInicial);
        // Create an ad request. Check your logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder().build();

        // Start loading the ad in the background.
        mAdView.loadAd(adRequest);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ecuaciones_lineales, menu);
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

    public void inicializarZ() {
        z1 = (EditText) findViewById(R.id.editTextZ1);
        z2 = (EditText) findViewById(R.id.editTextZ2);
        z3 = (EditText) findViewById(R.id.editTextZ3);
        Z1 = (TextView) findViewById(R.id.textViewZ1);
        Z2 = (TextView) findViewById(R.id.textViewZ2);
        Z3 = (TextView) findViewById(R.id.textViewZ3);
    }

    public void inicializarX() {
        x1 = (EditText) findViewById(R.id.editTextX1);
        x2 = (EditText) findViewById(R.id.editTextX2);
        x3 = (EditText) findViewById(R.id.editTextX3);
    }

    public void inicializarY() {
        y1 = (EditText) findViewById(R.id.editTextY1);
        y2 = (EditText) findViewById(R.id.editTextY2);
        y3 = (EditText) findViewById(R.id.editTextY3);
    }

    public void inicializarR() {
        r1 = (EditText) findViewById(R.id.editTextR1);
        r2 = (EditText) findViewById(R.id.editTextR2);
        r3 = (EditText) findViewById(R.id.editTextR3);
    }

    public void InicializarRs() {
        X = (TextView) findViewById(R.id.textViewRX);
        Y = (TextView) findViewById(R.id.textViewRY);
        Z = (TextView) findViewById(R.id.textViewRZ);
    }

    public void visualizarZ(boolean bandera) {

        z1.setEnabled(bandera);
        z2.setEnabled(bandera);
        z3.setEnabled(bandera);
        if (bandera) {
            Z1.setText("Z");
            Z2.setText("Z");
            Z3.setText("Z");
        } else {
            Z1.setText("");
            Z2.setText("");
            Z3.setText("");
        }

    }


    public void inicializar() {
        res = getResources();
        iniciar = (Button) findViewById(R.id.buttonRegistrar);
        lineal = new LinearLayout[3];
        lineal[0] = (LinearLayout) findViewById(R.id.eq1);
        lineal[1] = (LinearLayout) findViewById(R.id.eq2);
        lineal[2] = (LinearLayout) findViewById(R.id.eq3);
        Visualizar(3, false);
        Nvariables = (EditText) findViewById(R.id.editTextNVariables);
        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int variables = Integer.parseInt(Nvariables.getText().toString());
                    if (variables < 2 || variables > 3) {
                        throw new Exception();
                    } else {
                        if (variables == 2) {
                            visualizarZ(false);
                        } else {
                            visualizarZ(true);
                        }
                        Visualizar(variables, true);
                    }
                } catch (Exception ex) {
                    mensaje(res.getString(R.string.Admiten_Nvaribles));
                }

            }
        });

    }

    public void Visualizar(int n, boolean bandera) {
        for (int i = 0; i < lineal.length; i++) {
            lineal[i].setVisibility(LinearLayout.INVISIBLE);
        }
        for (int i = 0; i < n; i++) {
            if (bandera)
                lineal[i].setVisibility(LinearLayout.VISIBLE);
            else

                lineal[i].setVisibility(LinearLayout.INVISIBLE);
        }
    }

    public void mensaje(String men) {
        Toast.makeText(this, men, Toast.LENGTH_SHORT).show();
    }

    public void resolver(int nVarialbes) {
        try {
            double x1 = Double.parseDouble(this.x1.getText().toString());
            double x2 = Double.parseDouble(this.x2.getText().toString());
            double y1 = Double.parseDouble(this.y1.getText().toString());
            double y2 = Double.parseDouble(this.y2.getText().toString());
            double r1 = Double.parseDouble(this.r1.getText().toString());
            double r2 = Double.parseDouble(this.r2.getText().toString());
            Double y = 0.0;
            Double x = 0.0;
            if (nVarialbes == 2) {
                //Ax+By=C
                //Dx+Ey=F
                //
                //y = ((f * a) - (d * c)) / ((e * a) - (d * b));
                //x = (c - (b * y)) / a;

                y = ((r2 * x1) - (x2 * r1)) / ((y2 * x1) - (x2 * y1));
                x = (r1 - (y1 * y)) / x1;

            }
            if (nVarialbes == 3) {
                double x3 = Double.parseDouble(this.x3.getText().toString());
                double y3 = Double.parseDouble(this.y3.getText().toString());
                double z1 = Double.parseDouble(this.z1.getText().toString());
                double z2 = Double.parseDouble(this.z2.getText().toString());
                double z3 = Double.parseDouble(this.z3.getText().toString());
                double r3 = Double.parseDouble(this.r3.getText().toString());
                double d = (x1 * y2 * z3) + (y1 * z2 * x3) + (z1 * x2 * y3) - (z1 * y2 * x3) - (x1 * z2 * y3) - (y1 * x2 * z3);
                x = (r1 * y2 * z3) + (y1 * z2 * r3) + (z1 * r2 * y3) - (z1 * y2 * r3) - (r1 * z2 * y3) - (y1 * r2 * z3);
                y = (x1 * r2 * z3) + (r1 * z2 * x3) + (z1 * x2 * r3) - (z1 * r2 * x3) - (x1 * z2 * r3) - (r1 * x2 * z3);
                double z = (x1 * y2 * r3) + (y1 * r2 * x3) + (r1 * x2 * y3) - (r1 * y2 * x3) - (x1 * r2 * y3) - (y1 * x2 * r3);
                x = x / d;
                y = y / d;
                z = z / d;
                this.Z.setText(String.format("%.2f", z));

            }

            this.Y.setText(String.format("%.2f", y));
            this.X.setText(String.format("%.2f", x));
        } catch (Exception ex) {
            mensaje(res.getString(R.string.No_valido));
        }
    }

    private void inicializarBoton() {
        resolver = (Button) findViewById(R.id.buttonResolver);
        resolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    resolver(Integer.parseInt(Nvariables.getText().toString()));
                } catch (NumberFormatException ex) {
                    mensaje(res.getString(R.string.N_variables_novalido));
                }
            }
        });
    }
}

