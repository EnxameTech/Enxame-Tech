package com.recodepro.enxametech.service;

import com.recodepro.enxametech.model.Curso;

import java.util.List;

public interface CursoService {
    List<Curso> getAllCursos();
    Curso saveCurso(Curso curso);
    Curso getCursoById(Long id);
    Curso updateCurso(Long id, Curso updateCurso);
    void deleteById(Long id);
}
