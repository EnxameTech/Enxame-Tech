package com.recodepro.enxametech.service;

import java.util.List;

import com.recodepro.enxametech.model.Aluno;

public interface AlunoService {
    List<Aluno> getAllAlunos();
    Aluno saveAluno(Aluno aluno);
    Aluno getAlunoById(Long id);
    Aluno updateAluno(Long id, Aluno updateAluno);
    void deleteById(Long id);
}
