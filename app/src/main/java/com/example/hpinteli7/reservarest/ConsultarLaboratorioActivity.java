package com.example.hpinteli7.reservarest;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.util.List;
import java.util.concurrent.ExecutionException;

@SuppressLint("NewApi")
public class ConsultarLaboratorioActivity extends Activity{
    EditText codlabTxt;
    TextView celTxt;
    TextView idtcTxt;
    TextView plantaTxt;
    Button btnBuscar;
    List<Ciclo> ciclos;
    TableAdapter tabla;

    HttpURLConnection conn;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_laboratorio);

        codlabTxt = (EditText) findViewById(R.id.codlab);
        celTxt = (TextView) findViewById(R.id.cel);
        idtcTxt = (TextView) findViewById(R.id.idtc);
        plantaTxt = (TextView) findViewById(R.id.planta);
        btnBuscar =(Button)findViewById(R.id.btn_cicloExterno);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    public void consultarLab(View v) {
        String cod = codlabTxt.getText().toString();
        String url = null;
        JSONObject datosNota = new JSONObject();
        JSONObject nota = new JSONObject();

        try {
            String jsonText = new WebServiceTask().execute("http://cm12036pdm115.000webhostapp.com/ws_laboratorio_query.php?"+
                    "codlaboratorio="+cod).get();
           // System.out.println(jsonText);
            JSONArray jsonArray= new JSONArray(jsonText);

            if (jsonArray.length()==1){
                JSONObject object=jsonArray.getJSONObject(0);

                celTxt.setText(object.getString("IDTIPOCOMPUTO"));
                idtcTxt.setText(object.getString("CANTIDADEQUIPOSLABORATORIO"));
                plantaTxt.setText(object.getString("PLANTALABORATORIO"));
            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
