package com.example.hpinteli7.reservarest;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@SuppressLint("NewApi")
public class ConsultarAsignaturaActivity extends Activity{

    EditText codAsignaturaTxt;
    TextView idCicloTxt;
    TextView nombreAsignaturaTxt;
    Button btnBuscar;

    HttpURLConnection conn;
      @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_asignatura);


        codAsignaturaTxt = (EditText) findViewById(R.id.codasignatura);
        idCicloTxt = (TextView) findViewById(R.id.idciclo);
        nombreAsignaturaTxt = (TextView) findViewById(R.id.nombreasignatura);
        btnBuscar =(Button)findViewById(R.id.btn_asignaturaExterno);


          StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                  .permitAll().build();
          StrictMode.setThreadPolicy(policy);
    }


    public void consultarAsignatura(View v) {

        // String peticion= Conexion.getUrl() +"ws_consultar_municipio.php?";

        String codmateria = codAsignaturaTxt.getText().toString();
        String url = null;
        JSONObject datosNota = new JSONObject();
        JSONObject nota = new JSONObject();

        try {
            String jsonText = new WebServiceTask().execute("http://cm12036pdm115.000webhostapp.com/ws_asignatura_query.php?"+"codAsignatura="+codmateria).get();
            //System.out.println(jsonText);
            JSONArray  jsonArray= new JSONArray(jsonText);


            if (jsonArray.length()==1){
                JSONObject object=jsonArray.getJSONObject(0);

                idCicloTxt.setText(object.getString("IDCICLO"));
                nombreAsignaturaTxt.setText(object.getString("NOMBREASIGNATURA"));
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

