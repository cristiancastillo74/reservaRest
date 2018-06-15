package com.example.hpinteli7.reservarest;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ControlBDActivity extends Activity{

    private final Context context;
    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;

    public ControlBDActivity(Context ctx) {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {

        private static final String BASE_DATOS = "reserva.s3db";
        private static final int VERSION = 1;

        public DatabaseHelper(Context context) {
            super(context, BASE_DATOS, null, VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try {
                db.execSQL("CREATE TABLE ciclo(idciclo INTEGER NOT NULL PRIMARY KEY,numciclo INTEGER,anio INTEGER);");
                db.execSQL("CREATE TABLE asignatura(codasignatura VARCHAR(10) NOT NULL PRIMARY KEY,idciclo INTEGER NOT NULL, nombreasignatura varchar(50)NOT NULL);");
                //db.execSQL("CREATE TABLE materia(codmateria VARCHAR(6) NOT NULL PRIMARY KEY,nommateria VARCHAR(30),unidadesval VARCHAR(1));");
                //db.execSQL("CREATE TABLE nota(carnet VARCHAR(7) NOT NULL ,codmateria VARCHAR(6) NOT NULL ,ciclo VARCHAR(5) ,notafinal REAL ,PRIMARY KEY(carnet,codmateria,ciclo));");

            } catch (SQLException e) {

                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // TODO Auto-generated method stub
        }
    }
    public void abrir() throws SQLException {
        db = DBHelper.getWritableDatabase();
        return;
    }

    public void cerrar() {
        DBHelper.close();
    }

 /*   public String insertar(Materia materia) {

        String regInsertados = "Registro Insertado NÂº= ";
        long contador = 0;

        ContentValues mat = new ContentValues();
        mat.put("codmateria", materia.getCodMateria());
        mat.put("nommateria", materia.getNombreMateria());
        mat.put("unidadesval", materia.getUnidadesVal());
        contador = db.insert("materia", null, mat);

        if (contador == -1 || contador == 0) {
            regInsertados = "Error al Insertar el registro, Registro Duplicado. Verificar inserciÃ³n";
        } else {
            regInsertados = regInsertados + contador;
        }
        return regInsertados;
    }*/
}
