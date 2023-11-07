package com.recodepro.enxametech.model;

import java.time.LocalDate;

public class Usuario {
    private String CPF_usuario;
    private String nome;
    private String sobrenome;
    private LocalDate data_nascimento;
    private String email;
    private String senha;
    //private enum genero
    private String telefone;
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String UF;
    private String CEP;

    public Usuario(String CPF_usuario, String nome, String sobrenome, LocalDate data_nascimento, String email, String senha, String telefone, String rua, String numero, String bairro, String cidade, String UF, String CEP) {
        this.CPF_usuario = CPF_usuario;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.data_nascimento = data_nascimento;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.UF = UF;
        this.CEP = CEP;
    }

    public String getCPF_usuario() {
        return CPF_usuario;
    }
    public void setCPF_usuario(String CPF_usuario) {
        this.CPF_usuario = CPF_usuario;
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

    public LocalDate getData_nascimento() {
        return data_nascimento;
    }
    public void setData_nascimento(LocalDate data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getRua() {
        return rua;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUF() {
        return UF;
    }
    public void setUF(String UF) {
        this.UF = UF;
    }

    public String getCEP() {
        return CEP;
    }
    public void setCEP(String CEP) {
        this.CEP = CEP;
    }
}
