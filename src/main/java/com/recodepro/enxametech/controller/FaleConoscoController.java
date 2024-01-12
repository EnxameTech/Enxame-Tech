package com.recodepro.enxametech.controller;

import com.recodepro.enxametech.model.FaleConosco;
import com.recodepro.enxametech.service.FaleConoscoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity detalhar(@PathVariable Long id){
        try{
            FaleConosco faleConosco = fcs.getFaleConoscoById(id);
            return ResponseEntity.ok(faleConosco);
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Contato não encontrado!");
        }
    }

    @PostMapping("/enviar")
    public FaleConosco enviar(@RequestBody FaleConosco faleConosco){
        return fcs.saveFaleConosco(faleConosco);
    }
}
