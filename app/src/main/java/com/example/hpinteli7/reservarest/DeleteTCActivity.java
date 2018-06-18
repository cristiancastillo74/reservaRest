package com.example.hpinteli7.reservarest;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import org.json.JSONObject;

@SuppressLint("NewApi")
public class DeleteTCActivity extends AppCompatActivity {
    EditText idTCTxt;

    private final String urlHostingGratuito = "http://cm12036pdm115.000webhostapp.com/ws_tipocomputo_delete.php";

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_tc);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);

        idTCTxt = (EditText) findViewById(R.id.idciclo);
    }

    public void deleteTC(View v) {

        String id = idTCTxt.getText().toString();

        String url = null;
        JSONObject datosNota = new JSONObject();
        JSONObject nota = new JSONObject();
        switch (v.getId()) {
            case R.id.btn_cicloExterno:
                url = urlHostingGratuito + "?idTipoComputo=" + id;
                ControladorServicio.eliminarTCExterno(url, this);
                break;
        }

    }
}
