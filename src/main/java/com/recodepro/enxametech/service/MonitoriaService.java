package com.recodepro.enxametech.service;

import com.recodepro.enxametech.model.Aluno;
import com.recodepro.enxametech.model.Monitoria;

import java.util.List;

public interface MonitoriaService {
    List<Monitoria> getAllMonitorias();
    Monitoria getMonitoriaById(Long id);
    Monitoria getMonitoriasByIdAluno(Long id);
    Monitoria saveMonitoria(Monitoria monitoria, Aluno id);
}
