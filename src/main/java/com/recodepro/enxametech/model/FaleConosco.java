package com.recodepro.enxametech.model;

import jakarta.persistence.*;

@Entity
public class FaleConosco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_contato;

    @Column(nullable = false)
    private String nome_completo;

    @Column(nullable = false)
    private String CPF;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false)
    private String mensagem;

    public FaleConosco(Long id_contato, String nome_completo, String CPF, String email, String telefone,
                       String mensagem) {
        this.id_contato = id_contato;
        this.nome_completo = nome_completo;
        this.CPF = CPF;
        this.email = email;
        this.telefone = telefone;
        this.mensagem = mensagem;
    }

    public FaleConosco() {

    }

    public Long getId_contato() {
        return id_contato;
    }
    public void setId_contato(Long id_contato) {
        this.id_contato = id_contato;
    }

    public String getNome_completo() {
        return nome_completo;
    }
    public void setNome_completo(String nome_completo) {
        this.nome_completo = nome_completo;
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
