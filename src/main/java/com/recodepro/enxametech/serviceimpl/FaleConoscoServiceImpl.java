package com.recodepro.enxametech.serviceimpl;

import com.recodepro.enxametech.model.FaleConosco;
import com.recodepro.enxametech.repository.FaleConoscoRepository;
import com.recodepro.enxametech.service.FaleConoscoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaleConoscoServiceImpl implements FaleConoscoService {
    @Autowired
    private FaleConoscoRepository fcr;


    @Override
    public FaleConosco saveFaleConosco(FaleConosco faleConosco) {
        return fcr.save(faleConosco);
    }

    @Override
    public List<FaleConosco> getAllFaleConosco() {
        return fcr.findAll();
    }

    @Override
    public FaleConosco getFaleConoscoById(Long id) {
        return fcr.findById(id).orElseThrow(() -> new RuntimeException());
    }
}
