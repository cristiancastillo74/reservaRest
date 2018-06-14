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
public class InsertarCicloActivity extends Activity {
    EditText idcicloTxt;
    EditText numcicloTxt;
    EditText anioTxt;

    private final String urlHostingGratuito = "http://cm12036pdm115.000webhostapp.com/ws_ciclo_insert.php";

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_ciclo);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);

        idcicloTxt = (EditText) findViewById(R.id.idciclo);
        numcicloTxt = (EditText) findViewById(R.id.numciclo);
        anioTxt = (EditText) findViewById(R.id.anio);
    }

    public void insertarCiclo(View v) {

        String idciclo = idcicloTxt.getText().toString();
        String numciclo = numcicloTxt.getText().toString();
        String anio = anioTxt.getText().toString();

        String url = null;
        JSONObject datosNota = new JSONObject();
        JSONObject nota = new JSONObject();
        switch (v.getId()) {
            case R.id.btn_cicloExterno:
                url = urlHostingGratuito + "?idciclo=" + idciclo + "&numciclo="
                        + numciclo + "&anio=" + anio;
                ControladorServicio.insertarCicloExterno(url, this);
                break;
        }

    }
}
