package com.recodepro.enxametech.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.util.Objects;


@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String nome_empresa;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date dataFinal_inscricao;

    public Curso(Long id, String titulo, String nome_empresa, String descricao, Date dataFinal_inscricao) {
        this.id = id;
        this.titulo = titulo;
        this.nome_empresa = nome_empresa;
        this.descricao = descricao;
        this.dataFinal_inscricao = dataFinal_inscricao;
    }

    public Curso() {
    }

    // GETTERS
    public Long getId() {
        return id;
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
    public void setId(Long id) {
        this.id = id;
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
        return id == curso.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}