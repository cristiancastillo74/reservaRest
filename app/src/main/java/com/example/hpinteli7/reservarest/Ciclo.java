package com.example.hpinteli7.reservarest;

/**
 * Created by hp intel i7 on 13/06/2018.
 */

public class Ciclo {
    private int idciclo;
    private  int numciclo;
    private  int anio;

    public Ciclo() {
    }

    public Ciclo(int idciclo, int numciclo, int anio) {
        this.idciclo = idciclo;
        this.numciclo = numciclo;
        this.anio = anio;
    }

    public int getIdciclo() {
        return idciclo;
    }

    public void setIdciclo(int idciclo) {
        this.idciclo = idciclo;
    }

    public int getNumciclo() {
        return numciclo;
    }

    public void setNumciclo(int numciclo) {
        this.numciclo = numciclo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
}
