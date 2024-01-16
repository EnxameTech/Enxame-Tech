package com.recodepro.enxametech.repository;

import com.recodepro.enxametech.model.Voluntario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoluntarioRepository extends JpaRepository<Voluntario, Long> {
}
