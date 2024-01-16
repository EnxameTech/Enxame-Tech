package com.recodepro.enxametech.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class AlunoMonitoriaDTO {

    private Long aluno_id;
    private Long voluntario_id;
    private String descricao_duvida;
    private LocalDate data_monitoria;
    private LocalTime horario;

    public AlunoMonitoriaDTO() {
    }

    public AlunoMonitoriaDTO(Long aluno_id, Long voluntario_id, String descricao_duvida, LocalDate data_monitoria,
                             LocalTime horario) {
        this.aluno_id = aluno_id;
        this.voluntario_id = voluntario_id;
        this.descricao_duvida = descricao_duvida;
        this.data_monitoria = data_monitoria;
        this.horario = horario;
    }

    public Long getAluno_id() {
        return aluno_id;
    }
    public void setAluno_id(Long aluno_id) {
        this.aluno_id = aluno_id;
    }

    public Long getVoluntario_id() {
        return voluntario_id;
    }
    public void setVoluntario_id(Long voluntario_id) {
        this.voluntario_id = voluntario_id;
    }

    public String getDescricao_duvida() {
        return descricao_duvida;
    }
    public void setDescricao_duvida(String descricao_duvida) {
        this.descricao_duvida = descricao_duvida;
    }

    public LocalDate getData_monitoria() {
        return data_monitoria;
    }
    public void setData_monitoria(LocalDate data) {
        this.data_monitoria = data;
    }

    public LocalTime getHorario() {
        return horario;
    }
    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }
}
