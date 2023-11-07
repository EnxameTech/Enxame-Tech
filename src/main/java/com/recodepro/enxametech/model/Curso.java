package com.recodepro.enxametech.model;

import java.sql.Date;

public class Curso {

    private int id_curso;
    private String titulo;
    private String nome_empresa;
    private String descricao;
    private Date dataFinal_incricao;

    public Curso(int id_curso, String titulo, String nome_empresa, String descricao, Date dataFinal_incricao) {
        this.id_curso = id_curso;
        this.titulo = titulo;
        this.nome_empresa = nome_empresa;
        this.descricao = descricao;
        this.dataFinal_incricao = dataFinal_incricao;
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

    public Date getDataFinal_incricao() {
        return dataFinal_incricao;
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

    public void setDataFinal_incricao(Date dataFinal_incricao) {
        this.dataFinal_incricao = dataFinal_incricao;
    }

}