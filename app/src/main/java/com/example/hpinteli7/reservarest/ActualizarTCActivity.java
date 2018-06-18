package com.example.hpinteli7.reservarest;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import org.json.JSONObject;

@SuppressLint("NewApi")
public class ActualizarTCActivity extends AppCompatActivity {
           EditText idTCTxt;
        EditText nombreTCTxt;
        EditText desTCTxt;

        private final String urlHostingGratuito = "http://cm12036pdm115.000webhostapp.com/ws_tipocomputo_update.php";

        @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_tc);

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);

            idTCTxt = (EditText) findViewById(R.id.idciclo);
            nombreTCTxt = (EditText) findViewById(R.id.numciclo);
            desTCTxt = (EditText) findViewById(R.id.anio);
    }

    public void actualizarTC(View v) {

        String id = idTCTxt.getText().toString();
        String nom = nombreTCTxt.getText().toString();
        String des = desTCTxt.getText().toString();

        String url = null;
        JSONObject datosNota = new JSONObject();
        JSONObject nota = new JSONObject();
        switch (v.getId()) {
            case R.id.btn_cicloExterno:
                url = urlHostingGratuito + "?idTipoComputo=" + id + "&nombreTipo="
                        + nom + "&especificacionTecnica=" + des;
                ControladorServicio.actualizarTCExterno(url, this);
                break;
        }

    }
}
