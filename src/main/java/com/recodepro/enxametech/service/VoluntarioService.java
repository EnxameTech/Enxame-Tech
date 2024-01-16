package com.recodepro.enxametech.service;

import java.util.List;

import com.recodepro.enxametech.model.Voluntario;

public interface VoluntarioService {
    List<Voluntario> getAllVoluntarios();
    Voluntario saveVoluntario(Voluntario voluntario);
    Voluntario getVoluntarioById(long id);
    Voluntario updateVoluntarioById(long id, Voluntario voluntario);
    void deleteVoluntarioById(long id);

    //Monitoria
    List<Object[]> getMonitoriasVoluntario(Long id);

}
