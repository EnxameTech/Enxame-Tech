package com.recodepro.enxametech.model;

import com.recodepro.enxametech.enums.AreaDeAfinidade;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Voluntario extends Usuario {

    @Enumerated(EnumType.STRING)
    private AreaDeAfinidade areaDeAfinidade;

    @ManyToMany(mappedBy = "voluntarios")
    private Set<Aluno> alunos = new HashSet<>();

    public Voluntario(){}

    public AreaDeAfinidade getAreaDeAfinidade() {
        return areaDeAfinidade;
    }

    public void setAreaDeAfinidade(AreaDeAfinidade area_deAfinidade) {
        this.areaDeAfinidade = area_deAfinidade;
    }

    public Set<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(Set<Aluno> alunos) {
        this.alunos = alunos;
    }

}
