package com.recodepro.enxametech.repository;

import com.recodepro.enxametech.model.Aluno;
import com.recodepro.enxametech.model.Monitoria;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonitoriaRepository extends JpaRepository<Monitoria, Long> {
    List<Monitoria> findByAlunoId(Aluno alunoId);
}
