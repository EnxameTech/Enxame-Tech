package com.recodepro.enxametech.model;

import jakarta.persistence.*;

@Entity
public class Aluno extends Usuario {

    @Column(name = "grupo_familiar", nullable = false)
    private int grupo_familiar;

    @Column(name = "renda_familiar", nullable = false)
    private double renda_familiar;

    public int getGrupo_familiar() {
        return grupo_familiar;
    }

    public void setGrupo_familiar(int grupo_familiar) {
        this.grupo_familiar = grupo_familiar;
    }

    public double getRenda_familiar() {
        return renda_familiar;
    }

    public void setRenda_familiar(double renda_familiar) {
        this.renda_familiar = renda_familiar;
    }
}
