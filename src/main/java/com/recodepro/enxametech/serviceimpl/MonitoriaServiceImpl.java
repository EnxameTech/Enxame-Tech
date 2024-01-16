package com.recodepro.enxametech.serviceimpl;

import com.recodepro.enxametech.model.Monitoria;
import com.recodepro.enxametech.repository.MonitoriaRepository;
import com.recodepro.enxametech.service.MonitoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class MonitoriaServiceImpl implements MonitoriaService {
    @Autowired
    private MonitoriaRepository mr;

    @Override
    public List<Monitoria> getAllMonitorias() {
        return mr.findAll();
    }

    @Override
    public Monitoria getMonitoriaById(@PathVariable Long id) {
        return mr.findById(id).orElseThrow(()-> new RuntimeException());
    }
}
