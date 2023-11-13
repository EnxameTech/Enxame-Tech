//package com.recodepro.enxametech.model;
//
//import jakarta.persistence.*;
//import org.springframework.format.annotation.DateTimeFormat;
//
//import java.sql.Time;
//import java.time.LocalDate;
//
//@Entity
//public class Monitoria {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id_monitoria;
//
//    @ManyToOne
//    @JoinColumn(name="id_voluntario", nullable = false)
//    private Voluntario id_voluntario;
//
//    @ManyToOne
//    @JoinColumn(name="id_aluno", nullable = false)
//    private Aluno id_aluno;
//
//    @Column(name="data_monitoria", nullable = false)
//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
//    private LocalDate data_monitoria;
//
//    @Column(name="horario", nullable = false)
//    @Temporal(TemporalType.TIME)
//    private Time horario;
//
//    @Column(name="descricao_duvida")
//    private String descricao_duvida;
//
//    public Monitoria(Long id_monitoria, Voluntario id_voluntario, Aluno id_aluno, LocalDate data_monitoria, Time horario, String descricao_duvida) {
//        this.id_monitoria = id_monitoria;
//        this.id_voluntario = id_voluntario;
//        this.id_aluno = id_aluno;
//        this.data_monitoria = data_monitoria;
//        this.horario = horario;
//        this.descricao_duvida = descricao_duvida;
//    }
//    public Monitoria(){}
//
//    public Long getId_monitoria() {
//        return id_monitoria;
//    }
//    public void setId_monitoria(Long id_monitoria) {
//        this.id_monitoria = id_monitoria;
//    }
//
//    public Voluntario getId_voluntario() {
//        return id_voluntario;
//    }
//    public void setId_voluntario(Voluntario id_voluntario) {
//        this.id_voluntario = id_voluntario;
//    }
//
//    public Aluno getId_aluno() {
//        return id_aluno;
//    }
//    public void setId_aluno(Aluno id_aluno) {
//        this.id_aluno = id_aluno;
//    }
//
//    public LocalDate getData_monitoria() {
//        return data_monitoria;
//    }
//    public void setData_monitoria(LocalDate data_monitoria) {
//        this.data_monitoria = data_monitoria;
//    }
//
//    public Time getHorario() {
//        return horario;
//    }
//    public void setHorario(Time horario) {
//        this.horario = horario;
//    }
//
//    public String getDescricao_duvida() {
//        return descricao_duvida;
//    }
//    public void setDescricao_duvida(String descricao_duvida) {
//        this.descricao_duvida = descricao_duvida;
//    }
//}
