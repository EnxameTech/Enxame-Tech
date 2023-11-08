package com.recodepro.enxametech.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.util.Objects;


@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_curso;

    @Column(name="titulo", nullable = false)
    private String titulo;

    @Column(name="nome_empresa", nullable = false)
    private String nome_empresa;

    @Column(name="descricao", nullable = false)
    private String descricao;

    @Column(name="dataFinal_inscricao")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date dataFinal_inscricao;

    public Curso(int id_curso, String titulo, String nome_empresa, String descricao, Date dataFinal_inscricao) {
        this.id_curso = id_curso;
        this.titulo = titulo;
        this.nome_empresa = nome_empresa;
        this.descricao = descricao;
        this.dataFinal_inscricao = dataFinal_inscricao;
    }

    public Curso() {
    }

    // GETTERS
    public int getId_curso() {
        return id_curso;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getNome_empresa() {
        return nome_empresa;
    }

    public String getDescricao() {
        return descricao;
    }

    public Date getDataFinal_inscricao() {
        return dataFinal_inscricao;
    }

    // SETTERS
    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setNome_empresa(String nome_empresa) {
        this.nome_empresa = nome_empresa;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setDataFinal_inscricao(Date dataFinal_inscricao) {
        this.dataFinal_inscricao = dataFinal_inscricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curso curso = (Curso) o;
        return id_curso == curso.id_curso;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_curso);
    }
}