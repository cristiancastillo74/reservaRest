package com.example.hpinteli7.reservarest;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import org.json.JSONObject;

@SuppressLint("NewApi")
public class ActualizarCicloActivity extends AppCompatActivity {


        EditText idcicloTxt;
        EditText numcicloTxt;
        EditText anioTxt;

        private final String urlHostingGratuito = "http://cm12036pdm115.000webhostapp.com/ws_ciclo_update.php";

        @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_ciclo);


            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);

            idcicloTxt = (EditText) findViewById(R.id.idciclo);
            numcicloTxt = (EditText) findViewById(R.id.numciclo);
            anioTxt = (EditText) findViewById(R.id.anio);
        }

    public void actualizarCiclo(View v) {

        String idciclo = idcicloTxt.getText().toString();
        String numciclo = numcicloTxt.getText().toString();
        String anio = anioTxt.getText().toString();

        String url = null;
        switch (v.getId()) {
            case R.id.btn_cicloExterno:
                url = urlHostingGratuito + "?idciclo=" + idciclo + "&numciclo="
                        + numciclo + "&anio=" + anio;
                ControladorServicio.actualizarCicloExterno(url, this);
                break;
        }

    }
}
