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
public class InsertarAsignaturaActivity extends Activity {
    EditText codAsignaturaTxt;
    EditText idCicloTxt;
    EditText nombreAsignaturaTxt;

    private final String urlHostingGratuito = "http://cm12036pdm115.000webhostapp.com/ws_asignatura_insert.php";

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_asignatura);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);

        codAsignaturaTxt = (EditText) findViewById(R.id.codasignatura);
        idCicloTxt = (EditText) findViewById(R.id.idciclo);
        nombreAsignaturaTxt = (EditText) findViewById(R.id.nombreasignatura);
    }

    public void insertarAsignatura(View v) {

        String codAsignatura = codAsignaturaTxt.getText().toString();
        String idciclo = idCicloTxt.getText().toString();
        String nombreAsignatura = nombreAsignaturaTxt.getText().toString();

        String url = null;
        JSONObject datosAsignatura = new JSONObject();
        JSONObject nota = new JSONObject();
        switch (v.getId()) {
            case R.id.btn_asignaturaExterno:
                url = urlHostingGratuito + "?codAsignatura=" + codAsignatura + "&idCiclo="
                        + idciclo + "&nombreAsignatura=" + nombreAsignatura;
                ControladorServicio.insertarAsignaturaExterno(url, this);
                break;
        }

    }
}
