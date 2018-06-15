package com.example.hpinteli7.reservarest;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void lanzarActividad(View v){

        Intent i = null;

        switch(v.getId()){

            case R.id.buttonCicloActualizar:
                i = new Intent(this,ActualizarCicloActivity.class);
                break;
            case R.id.buttonCicloDelete:
                i = new Intent(this,DeleteCicloActivity.class);
                break;
            case R.id.buttonCicloInsertar:
                i = new Intent(this,InsertarCicloActivity.class);
                break;
            case R.id.buttonCicloConsultar:
                i = new Intent(this,ConsultarCicloActivity.class);
                break;


            case R.id.buttonAsignaturaActualizar:
                i = new Intent(this,ActualizarCicloActivity.class);
                break;
            case R.id.buttonAsignaturaDelete:
                i = new Intent(this,DeleteCicloActivity.class);
                break;
            case R.id.buttonAsignaturaInsertar:
                i = new Intent(this,InsertarCicloActivity.class);
                break;
            case R.id.buttonAsignaturaConsultar:
                i = new Intent(this,ConsultarCicloActivity.class);
                break;
        }

        if(i!=null)
            startActivity(i);
    }

}