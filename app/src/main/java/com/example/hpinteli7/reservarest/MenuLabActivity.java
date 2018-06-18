package com.example.hpinteli7.reservarest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuLabActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_lab);
    }

    public void lanzarActividad(View v){
        Intent i = null;

        switch(v.getId()){

            case R.id.buttonCicloActualizar:
                i = new Intent(this,ActualizarLaboratorioActivity.class);
                break;
            case R.id.buttonCicloDelete:
                i = new Intent(this,DeleteLaboratorioActivity.class);
                break;
            case R.id.buttonCicloInsertar:
                i = new Intent(this,InsertarLaboratorioActivity.class);
                break;
            case R.id.buttonCicloConsultar:
                i = new Intent(this,ConsultarLaboratorioActivity.class);
                break;

        }

        if(i!=null)
            startActivity(i);
    }
}
