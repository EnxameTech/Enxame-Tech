package com.recodepro.enxametech.repository;

import com.recodepro.enxametech.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

}
