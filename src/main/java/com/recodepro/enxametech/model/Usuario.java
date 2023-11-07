package com.recodepro.enxametech.model;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Usuario {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario usuario)) return false;
        return Objects.equals(getCPF_usuario(), usuario.getCPF_usuario()) && Objects.equals(getNome(), usuario.getNome()) && Objects.equals(getSobrenome(), usuario.getSobrenome()) && Objects.equals(getData_nascimento(), usuario.getData_nascimento()) && Objects.equals(getEmail(), usuario.getEmail()) && Objects.equals(getSenha(), usuario.getSenha()) && Objects.equals(getTelefone(), usuario.getTelefone()) && Objects.equals(getRua(), usuario.getRua()) && Objects.equals(getNumero(), usuario.getNumero()) && Objects.equals(getBairro(), usuario.getBairro()) && Objects.equals(getCidade(), usuario.getCidade()) && Objects.equals(getUF(), usuario.getUF()) && Objects.equals(getCEP(), usuario.getCEP());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCPF_usuario(), getNome(), getSobrenome(), getData_nascimento(), getEmail(), getSenha(), getTelefone(), getRua(), getNumero(), getBairro(), getCidade(), getUF(), getCEP());
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "CPF_usuario='" + CPF_usuario + '\'' +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", data_nascimento=" + data_nascimento +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", telefone='" + telefone + '\'' +
                ", rua='" + rua + '\'' +
                ", numero='" + numero + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", UF='" + UF + '\'' +
                ", CEP='" + CEP + '\'' +
                '}';
    }
}
