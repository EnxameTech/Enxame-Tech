package com.recodepro.enxametech.controller;

import com.recodepro.enxametech.model.Monitoria;
import com.recodepro.enxametech.service.AlunoService;
import com.recodepro.enxametech.service.MonitoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monitoria")
public class MonitoriaController {

    @Autowired
    private MonitoriaService ms;

    @Autowired
    private AlunoService as;

    @GetMapping("/listar")
    public List<Monitoria> listar(){
        return ms.getAllMonitorias();
    }

    @GetMapping("/detalhar/{id}")
    public ResponseEntity<Monitoria> detalhar(@PathVariable Long id){
        try {
            Monitoria monitoria = ms.getMonitoriaById(id);
            return ResponseEntity.ok(monitoria);
        }catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
