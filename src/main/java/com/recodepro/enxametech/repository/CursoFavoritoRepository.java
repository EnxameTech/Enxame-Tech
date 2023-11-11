package com.recodepro.enxametech.repository;

import com.recodepro.enxametech.model.Aluno;
import com.recodepro.enxametech.model.Curso;
import com.recodepro.enxametech.model.CursoFavorito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoFavoritoRepository extends JpaRepository<CursoFavorito, Integer> {
    // vai os cursos favoritos de um determinado aluno
    CursoFavorito findById_aluno(Aluno id_aluno);
    // vai procurar os alunos que favoritaram este curso
    CursoFavorito findById_curso(Curso id_curso);
}
