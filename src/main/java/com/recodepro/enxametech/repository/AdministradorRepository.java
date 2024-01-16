package com.recodepro.enxametech.repository;

import com.recodepro.enxametech.model.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Long> {
}
