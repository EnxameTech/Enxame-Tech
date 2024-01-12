package com.recodepro.enxametech.service;

import com.recodepro.enxametech.model.Administrador;
import java.util.List;

public interface AdministradorService {
    List<Administrador> getAllAdms();
    Administrador saveAdm(Administrador adm);
    Administrador getAdmById(Long id);
    Administrador updateAdm(Long id, Administrador updateAdm);
    void deleteById(Long id);
}
