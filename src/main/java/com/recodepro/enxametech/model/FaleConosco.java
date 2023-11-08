package com.recodepro.enxametech.model;

import jakarta.persistence.*;

@Entity
public class FaleConosco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_contato;

    @Column(name="nome", nullable = false)
    private String nome;

    @Column(name="sobrenome", nullable = false)
    private String sobrenome;

    @Column(name="CPF", nullable = false)
    private String CPF;

    @Column(name="email", nullable = false)
    private String email;

    @Column(name="telefone", nullable = false)
    private String telefone;

    @Column(name="mensagem", nullable = false)
    private String mensagem;

    public FaleConosco(int id_contato, String nome, String sobrenome, String CPF, String email, String telefone, String mensagem) {
        this.id_contato = id_contato;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.CPF = CPF;
        this.email = email;
        this.telefone = telefone;
        this.mensagem = mensagem;
    }

    public FaleConosco() {

    }

    public int getId_contato() {
        return id_contato;
    }
    public void setId_contato(int id_contato) {
        this.id_contato = id_contato;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCPF() {
        return CPF;
    }
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getMensagem() {
        return mensagem;
    }
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }


}
