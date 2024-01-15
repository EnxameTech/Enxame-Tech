package com.recodepro.enxametech.serviceimpl;

import com.recodepro.enxametech.model.Aluno;
import com.recodepro.enxametech.model.Monitoria;
import com.recodepro.enxametech.repository.AlunoRepository;
import com.recodepro.enxametech.repository.MonitoriaRepository;
import com.recodepro.enxametech.service.MonitoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonitoriaServiceImpl implements MonitoriaService {
    @Autowired
    private MonitoriaRepository mr;

    @Autowired
    private AlunoRepository ar;


    @Override
    public List<Monitoria> getAllMonitorias() {
        return mr.findAll();
    }

    @Override
    public Monitoria getMonitoriaById(Long id) {
        return mr.findById(id).orElseThrow(()-> new RuntimeException());
    }

    @Override
    public Monitoria getMonitoriasByIdAluno(Long id) {
        return null;
    }

    @Override
    public Monitoria saveMonitoria(Monitoria monitoria, Aluno id) {
        return null;
    }
}
