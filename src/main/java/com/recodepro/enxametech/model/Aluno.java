package com.recodepro.enxametech.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Aluno extends Usuario {

    @Column(nullable = false)
    private int grupo_familiar;

    @Column(nullable = false)
    private double renda_familiar;

    @ManyToMany
    @JoinTable(name = "monitoria",
            joinColumns = @JoinColumn(name = "aluno_id"),
            inverseJoinColumns = @JoinColumn(name = "voluntario_id"))
    private Set<Voluntario> voluntarios = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "curso_favorito",
            joinColumns = @JoinColumn(name = "aluno_id"),
            inverseJoinColumns = @JoinColumn(name = "curso_id"))
    private Set<Curso> cursosFavoritos = new HashSet<>();

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CursoFavorito> cursoFavoritos = new ArrayList<>();

    public Aluno() {}

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

    public List<CursoFavorito> getCursoFavoritos() {
        return cursoFavoritos;
    }

    public void setCursoFavoritos(CursoFavorito cursoFavorito) {
        cursoFavoritos.add(cursoFavorito);
        cursoFavorito.setAluno(this);
    }

    public void removeCursoFavorito(CursoFavorito cursoFavorito) {
        cursoFavoritos.remove(cursoFavorito);
        cursoFavorito.setAluno(null);
    }
}
