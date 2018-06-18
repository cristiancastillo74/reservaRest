package com.example.hpinteli7.reservarest;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

@SuppressLint("NewApi")
public class DeleteLaboratorioActivity extends Activity{
    EditText codlabTxt;


    private final String urlHostingGratuito = "http://cm12036pdm115.000webhostapp.com/ws_laboratorio_delete.php";

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_laboratorio);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);

        codlabTxt = (EditText) findViewById(R.id.codlab);
    }

    public void EliminarLab(View v) {

        String cod = codlabTxt.getText().toString();

        String url = null;
        switch (v.getId()) {
            case R.id.btn_cicloExterno:
                url = urlHostingGratuito + "?codlaboratorio=" + cod;
                ControladorServicio.eliminarLaboratorioExterno(url, this);
                break;
        }

    }
}
