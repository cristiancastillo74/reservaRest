package com.example.hpinteli7.reservarest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuTCActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_tc);
    }

    public void lanzarActividad(View v){

        Intent i = null;

        switch(v.getId()){

            case R.id.buttonAsignaturaActualizar:
                i = new Intent(this,ActualizarTCActivity.class);
                break;
            case R.id.buttonAsignaturaDelete:
                i = new Intent(this,DeleteTCActivity.class);
                break;
            case R.id.buttonAsignaturaInsertar:
                i = new Intent(this,InsertarTCActivity.class);
                break;
            case R.id.buttonAsignaturaConsultar:
                i = new Intent(this,ConsultarTCActivity.class);
                break;
        }

        if(i!=null)
            startActivity(i);
    }
}
