package com.recodepro.enxametech.model;

import com.recodepro.enxametech.enums.AreaDeAfinidade;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Voluntario extends Usuario {

    @Enumerated(EnumType.STRING)
    private AreaDeAfinidade area_deAfinidade;

    @ManyToMany(mappedBy = "voluntarios")
    private Set<Aluno> alunos = new HashSet<>();

    public Voluntario(){}

    public AreaDeAfinidade getAreaDeAfinidade() {
        return area_deAfinidade;
    }

    public void setAreaDeAfinidade(AreaDeAfinidade area_deAfinidade) {
        this.area_deAfinidade = area_deAfinidade;
    }
}
