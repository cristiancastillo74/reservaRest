package com.example.hpinteli7.reservarest;

import android.annotation.SuppressLint;
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
public class ConsultarTCActivity extends AppCompatActivity {
    EditText idcicloTxt;
    TextView numcicloTxt;
    TextView anioTxt;
    Button btnBuscar;

    private final String urlHostingGratuito = "http://cm12036pdm115.000webhostapp.com/ws_asignatura_query.php";

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_tc);

        idcicloTxt = (EditText) findViewById(R.id.idciclo);
        numcicloTxt = (TextView) findViewById(R.id.numciclo);
        anioTxt = (TextView) findViewById(R.id.anio);
        btnBuscar =(Button)findViewById(R.id.btn_cicloExterno);
    }

    public void consultarTC(View v) {

        // String peticion= Conexion.getUrl() +"ws_consultar_municipio.php?";

        String idciclo = idcicloTxt.getText().toString();
        String url = null;
        JSONObject datosNota = new JSONObject();
        JSONObject nota = new JSONObject();

        try {
            String jsonText = new WebServiceTask().execute("http://cm12036pdm115.000webhostapp.com/ws_tipocomputo_query.php?"+"idTipoComputo="+idciclo).get();
            //System.out.println(jsonText);
            JSONArray jsonArray= new JSONArray(jsonText);


            if (jsonArray.length()==1){
                JSONObject object=jsonArray.getJSONObject(0);

                numcicloTxt.setText(object.getString("NOMBRETIPO"));
                anioTxt.setText(object.getString("ESPECIFICACIONTECNICA"));
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
