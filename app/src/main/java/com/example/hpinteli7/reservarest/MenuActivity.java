package com.example.hpinteli7.reservarest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void lanzarActividad(View v){

        Intent i = null;

        switch(v.getId()){

            case R.id.buttonMenuAsinatura:
                i = new Intent(this,MenuAsignaturaActivity.class);
                break;
            case R.id.buttonMenuCiclo:
                i = new Intent(this,MenuCicloActivity.class);
                break;
            case R.id.buttonMenuTipoComputo:
                i = new Intent(this,MenuTCActivity.class);
                break;
            case R.id.buttonMenuLab:
                i = new Intent(this,MenuLabActivity.class);
                break;

        }

        if(i!=null)
            startActivity(i);
    }
}
