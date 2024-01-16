package com.recodepro.enxametech.service;

import java.util.List;

import com.recodepro.enxametech.model.*;

public interface AlunoService {
    //Aluno
    List<Aluno> getAllAlunos();
    Aluno saveAluno(Aluno aluno);
    Aluno getAlunoById(Long id);
    Aluno updateAluno(Long id, Aluno updateAluno);
    void deleteById(Long id);

    //Monitoria
    List<Object[]> getMonitoriasAluno(Long id);
    Monitoria saveMonitoria(AlunoMonitoriaDTO amDTO);

    //Curso Favorito
    List<Object[]> getCursosFavAluno(Long id);
    CursoFavorito saveCursoFav(AlunoCursoFavDTO acfDTO);
}
