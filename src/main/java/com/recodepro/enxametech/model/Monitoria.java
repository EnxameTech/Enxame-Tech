package com.recodepro.enxametech.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Monitoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_monitoria;

    @ManyToOne
    @JoinColumn(name = "voluntario_id", nullable = false)
    private Voluntario voluntario;

    @ManyToOne
    @JoinColumn(name="aluno_id", nullable = false)
    private Aluno aluno;

    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate data_monitoria;

    @Column(nullable = false)
    @Temporal(TemporalType.TIME)
    private LocalTime horario;

    private String descricao_duvida;

    public Monitoria(Long id_monitoria, Voluntario voluntario, Aluno aluno, LocalDate data_monitoria, LocalTime horario,
                     String descricao_duvida) {
        this.id_monitoria = id_monitoria;
        this.voluntario = voluntario;
        this.aluno = aluno;
        this.data_monitoria = data_monitoria;
        this.horario = horario;
        this.descricao_duvida = descricao_duvida;
    }
    public Monitoria(){}

    public Long getId_monitoria() {
        return id_monitoria;
    }
    public void setId_monitoria(Long id_monitoria) {
        this.id_monitoria = id_monitoria;
    }

    public Voluntario getVoluntario() {
        return voluntario;
    }
    public void setVoluntario(Voluntario voluntario) {
        this.voluntario = voluntario;
    }

    public Aluno getAluno() {
        return aluno;
    }
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public LocalDate getData_monitoria() {
        return data_monitoria;
    }
    public void setData_monitoria(LocalDate data_monitoria) {
        this.data_monitoria = data_monitoria;
    }

    public LocalTime getHorario() {
        return horario;
    }
    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public String getDescricao_duvida() {
        return descricao_duvida;
    }
    public void setDescricao_duvida(String descricao_duvida) {
        this.descricao_duvida = descricao_duvida;
    }
}
