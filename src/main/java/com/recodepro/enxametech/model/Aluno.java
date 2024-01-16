package com.recodepro.enxametech.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
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
    @JsonIgnore
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

    public Set<Voluntario> getVoluntarios() {
        return voluntarios;
    }

    public void setVoluntarios(Set<Voluntario> voluntarios) {
        this.voluntarios = voluntarios;
    }

    public Set<Curso> getCursosFavoritos() {
        return cursosFavoritos;
    }

    public void setCursosFavoritos(Set<Curso> cursosFavoritos) {
        this.cursosFavoritos = cursosFavoritos;
    }

    public List<CursoFavorito> getCursoFavoritos() {
        return cursoFavoritos;
    }

    public void setCursoFavoritos(List<CursoFavorito> cursoFavoritos) {
        this.cursoFavoritos = cursoFavoritos;
    }

    @Override
    public String toString() {
        return "Aluno [grupo_familiar=" + grupo_familiar + ", renda_familiar=" + renda_familiar + ", voluntarios="
                + voluntarios + ", cursosFavoritos=" + cursosFavoritos + ", cursoFavoritos=" + cursoFavoritos + "]";
    }

}
