package com.recodepro.enxametech.repository;

import com.recodepro.enxametech.model.FaleConosco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaleConoscoRepository extends JpaRepository<FaleConosco, Long> {
}
