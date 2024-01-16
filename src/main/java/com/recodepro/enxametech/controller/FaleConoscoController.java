package com.recodepro.enxametech.controller;

import com.recodepro.enxametech.model.FaleConosco;
import com.recodepro.enxametech.service.FaleConoscoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fale-conosco")
public class FaleConoscoController {

    @Autowired
    private FaleConoscoService fcs;

    @GetMapping("/listar")
    public List<FaleConosco> listar(){
        return fcs.getAllFaleConosco();
    }

    @GetMapping("/detalhar/{id}")
    public ResponseEntity<FaleConosco> detalhar(@PathVariable Long id){
        try{
            FaleConosco faleConosco = fcs.getFaleConoscoById(id);
            return ResponseEntity.ok(faleConosco);
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/enviar")
    public ResponseEntity<FaleConosco> enviar(@RequestBody FaleConosco faleConosco){
        try {
            FaleConosco novoFaleConosco = fcs.saveFaleConosco(faleConosco);
            return ResponseEntity.ok(novoFaleConosco);
        }catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
