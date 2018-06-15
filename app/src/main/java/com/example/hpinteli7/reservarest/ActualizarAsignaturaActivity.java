package com.example.hpinteli7.reservarest;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


@SuppressLint("NewApi")
public class ActualizarAsignaturaActivity extends AppCompatActivity {


    EditText codAsignaturaTxt;
    EditText idCicloTxt;
    EditText nombreAsignaturaTxt;


    private final String urlHostingGratuito = "http://cm12036pdm115.000webhostapp.com/ws_asignatura_update.php";

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_asignatura);


        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);

        codAsignaturaTxt = (EditText) findViewById(R.id.codasignatura);
        idCicloTxt = (EditText) findViewById(R.id.idciclo);
        nombreAsignaturaTxt = (EditText) findViewById(R.id.nombreasignatura);
    }

    public void actualizarAsignatura(View v) {

        String codAsignatura = codAsignaturaTxt.getText().toString();
        String idciclo = idCicloTxt.getText().toString();
        String nombreAsignatura = nombreAsignaturaTxt.getText().toString();

        String url = null;
        switch (v.getId()) {
            case R.id.btn_cicloExterno:
                url = urlHostingGratuito + "?codasignatura=" + codAsignatura + "&idciclo="
                        + idciclo + "&nombreasignatura=" + nombreAsignatura;
                ControladorServicio.actualizarAsignaturaExterno(url, this);
                break;
        }

    }
}
