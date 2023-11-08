package com.recodepro.enxametech.model;

import com.recodepro.enxametech.enums.Genero;
import com.recodepro.enxametech.enums.UF;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@MappedSuperclass
public abstract class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="nome", nullable = false)
    private String nome;

    @Column(name="sobrenome", nullable = false)
    private String sobrenome;

    @Column(name = "data_nascimento", nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate data_nascimento;

    @Column(name="email", nullable = false, unique = true)
    private String email;

    @Column(name="senha", nullable = false)
    private String senha;

    @Column(name="genero", nullable = false)
    @Enumerated(EnumType.STRING)
    private Genero genero;

    @Column(name="telefone", nullable = false)
    private String telefone;

    @Column(name="rua", nullable = false)
    private String rua;

    @Column(name="numero", nullable = false)
    private String numero;

    @Column(name="bairro", nullable = false)
    private String bairro;

    @Column(name="cidade", nullable = false)
    private String cidade;

    @Column(name="UF", nullable = false)
    @Enumerated(EnumType.STRING)
    private UF UF;

    @Column(name="CEP", nullable = false)
    private String CEP;

    @Column(name="CPF", nullable = false, unique = true)
    private String CPF;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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

    public Genero getGenero() {
        return genero;
    }
    public void setGenero(Genero genero) {
        this.genero = genero;
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

    public com.recodepro.enxametech.enums.UF getUF() {
        return UF;
    }
    public void setUF(com.recodepro.enxametech.enums.UF UF) {
        this.UF = UF;
    }

    public String getCEP() {
        return CEP;
    }
    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getCPF() {
        return CPF;
    }
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
}
