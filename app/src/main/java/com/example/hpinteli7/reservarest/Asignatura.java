package com.example.hpinteli7.reservarest;

/**
 * Created by Melissa on 14/06/2018.
 */

public class Asignatura {

    private String codasignatura;
    private int idciclo;
    private String nombreasignatura;

    public Asignatura(String codasignatura) {
        this.codasignatura = codasignatura;
    }

    public Asignatura(String codasignatura, int idciclo, String nombreasignatura) {
        this.codasignatura = codasignatura;
        this.idciclo = idciclo;
        this.nombreasignatura = nombreasignatura;
    }

    public String getCodasignatura() {
        return codasignatura;
    }

    public void setCodasignatura(String codasignatura) {
        this.codasignatura = codasignatura;
    }

    public int getIdciclo() {
        return idciclo;
    }

    public void setIdciclo(int idciclo) {
        this.idciclo = idciclo;
    }

    public String getNombreasignatura() {
        return nombreasignatura;
    }

    public void setNombreasignatura(String nombreasignatura) {
        this.nombreasignatura = nombreasignatura;
    }
}
