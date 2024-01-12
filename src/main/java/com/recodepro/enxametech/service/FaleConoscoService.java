package com.recodepro.enxametech.service;

import com.recodepro.enxametech.model.FaleConosco;

import java.util.List;

public interface FaleConoscoService {
    FaleConosco saveFaleConosco(FaleConosco faleConosco);
    List<FaleConosco> getAllFaleConosco();
    FaleConosco getFaleConoscoById(Long id);
}
