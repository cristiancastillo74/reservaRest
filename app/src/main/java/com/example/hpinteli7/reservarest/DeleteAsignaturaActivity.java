package com.example.hpinteli7.reservarest;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

@SuppressLint("NewApi")

public class DeleteAsignaturaActivity extends Activity {

    EditText codAsignaturaTxt;


    private final String urlHostingGratuito = "http://cm12036pdm115.000webhostapp.com/ws_asignatura_delete.php";

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_asignatura);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);

        codAsignaturaTxt = (EditText) findViewById(R.id.codasignatura);
    }

    public void eliminarAsignatura(View v) {

        String codasignatura = codAsignaturaTxt.getText().toString();

        String url = null;
        switch (v.getId()) {
            case R.id.btn_asignaturaExterno:
                url = urlHostingGratuito + "?codasignatura=" + codasignatura;
                ControladorServicio.eliminarAsignaturaExterno(url, this);
                break;
        }

    }
}
