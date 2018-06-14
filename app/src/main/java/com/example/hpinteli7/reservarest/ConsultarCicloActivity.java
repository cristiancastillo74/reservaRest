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
public class ConsultarCicloActivity extends Activity{

    EditText idcicloTxt;
    TextView numcicloTxt;
    TextView anioTxt;
    Button btnBuscar;
    List<Ciclo> ciclos;
    TableAdapter tabla;

    HttpURLConnection conn;
    private final String urlHostingGratuito = "http://cm12036pdm115.000webhostapp.com/ws_ciclo_query.php";

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_ciclo);

        idcicloTxt = (EditText) findViewById(R.id.idciclo);
        numcicloTxt = (TextView) findViewById(R.id.numciclo);
        anioTxt = (TextView) findViewById(R.id.anio);
        btnBuscar =(Button)findViewById(R.id.btn_cicloExterno);



        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);

    }

    public void consultarCiclo(View v) {

       // String peticion= Conexion.getUrl() +"ws_consultar_municipio.php?";

        String idciclo = idcicloTxt.getText().toString();
        String url = null;
        JSONObject datosNota = new JSONObject();
        JSONObject nota = new JSONObject();

        try {
            String jsonText = new WebServiceTask().execute("http://cm12036pdm115.000webhostapp.com/ws_ciclo_query.php?"+"idciclo="+idciclo).get();
            //System.out.println(jsonText);
            JSONArray  jsonArray= new JSONArray(jsonText);


            if (jsonArray.length()==1){
                JSONObject object=jsonArray.getJSONObject(0);

                numcicloTxt.setText(object.getString("NUMCICLO"));
                anioTxt.setText(object.getString("ANIO"));
                }



            //  for (int i=0;i<jsonArray.length();i++){
            // idciclo= String.valueOf(object.getInt("IDCICLO"));}

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }




    }

