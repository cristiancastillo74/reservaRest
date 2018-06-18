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
public class InsertarLaboratorioActivity extends Activity {
    EditText codlabTxt;
    EditText celTxt;
    EditText idtcTxt;
    EditText plantaTxt;

    private final String urlHostingGratuito = "http://cm12036pdm115.000webhostapp.com/ws_laboratorio_insert.php";

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_laboratorio);


    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);

        codlabTxt = (EditText) findViewById(R.id.codlab);
        celTxt = (EditText) findViewById(R.id.cel);
        idtcTxt = (EditText) findViewById(R.id.idtc);
        plantaTxt = (EditText) findViewById(R.id.platalab);
    }

    public void insertarLab(View v) {

        String codlab = codlabTxt.getText().toString();
        String cel = celTxt.getText().toString();
        String idtc = idtcTxt.getText().toString();
        String planta = plantaTxt.getText().toString();

        String url = null;
        JSONObject datosNota = new JSONObject();
        JSONObject nota = new JSONObject();
        switch (v.getId()) {
            case R.id.btn_cicloExterno:
                url = urlHostingGratuito + "?codlaboratorio=" + codlab + "&cantidadequiposlaboratorio="
                        + cel + "&idtipocomputo=" + idtc + "&plantalaboratorio=" + planta;
                //System.out.println(url);
                ControladorServicio.insertarLaboratorioExterno(url, this);
                break;
        }

    }
}
