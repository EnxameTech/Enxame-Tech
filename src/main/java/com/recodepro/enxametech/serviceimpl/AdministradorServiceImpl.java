package com.recodepro.enxametech.serviceimpl;

import com.recodepro.enxametech.model.Administrador;
import com.recodepro.enxametech.repository.AdministradorRepository;
import com.recodepro.enxametech.service.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministradorServiceImpl implements AdministradorService {
    @Autowired
    private AdministradorRepository ar;

    @Override
    public List<Administrador> getAllAdms() {
        return ar.findAll();
    }

    @Override
    public Administrador saveAdm(Administrador adm) {
        return ar.save(adm);
    }

    @Override
    public Administrador getAdmById(Long id) {
        return ar.findById(id).orElseThrow(()-> new RuntimeException());
    }

    @Override
    public Administrador updateAdm(Long id, Administrador updateAdm) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        Administrador adm = ar.findById(id).orElseThrow(()-> new RuntimeException());
        ar.deleteById(adm.getId());
    }
}
