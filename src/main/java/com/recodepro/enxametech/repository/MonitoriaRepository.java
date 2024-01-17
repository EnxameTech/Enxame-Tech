package com.recodepro.enxametech.repository;

import com.recodepro.enxametech.model.Monitoria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonitoriaRepository extends JpaRepository<Monitoria, Long> {
}
