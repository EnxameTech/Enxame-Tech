package com.recodepro.enxametech.service;

import java.util.List;

import com.recodepro.enxametech.model.Aluno;
import com.recodepro.enxametech.model.AlunoMonitoriaDTO;
import com.recodepro.enxametech.model.Monitoria;

public interface AlunoService {
    List<Aluno> getAllAlunos();
    Aluno saveAluno(Aluno aluno);
    Aluno getAlunoById(Long id);
    Aluno updateAluno(Long id, Aluno updateAluno);
    void deleteById(Long id);
    List<Object[]> getMonitoriasAluno(Long id);
    Monitoria saveMonitoria(AlunoMonitoriaDTO amDTO);
}
