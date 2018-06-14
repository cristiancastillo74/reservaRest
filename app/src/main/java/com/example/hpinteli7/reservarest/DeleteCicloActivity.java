package com.example.hpinteli7.reservarest;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

@SuppressLint("NewApi")
public class DeleteCicloActivity extends Activity{

    EditText idcicloTxt;


    private final String urlHostingGratuito = "http://cm12036pdm115.000webhostapp.com/ws_ciclo_delete.php";

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_ciclo);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);

        idcicloTxt = (EditText) findViewById(R.id.idciclo);
    }

    public void eliminarCiclo(View v) {

        String idciclo = idcicloTxt.getText().toString();

        String url = null;
        switch (v.getId()) {
            case R.id.btn_cicloExterno:
                url = urlHostingGratuito + "?idciclo=" + idciclo;
                ControladorServicio.eliminarCicloExterno(url, this);
                break;
        }

    }
}
