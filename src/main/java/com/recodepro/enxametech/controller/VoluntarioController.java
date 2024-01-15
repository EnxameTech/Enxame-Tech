package com.recodepro.enxametech.controller;

import com.recodepro.enxametech.model.Voluntario;
import com.recodepro.enxametech.service.VoluntarioService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/voluntario")
public class VoluntarioController {

    @Autowired
    private VoluntarioService vs;

    @GetMapping("/listar")
    public List<Voluntario> listar() {
        return vs.getAllVoluntarios();
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Voluntario> cadastrar(@RequestBody Voluntario voluntario) {
        try {
            Voluntario novoVoluntario = vs.saveVoluntario(voluntario);
            return ResponseEntity.ok(novoVoluntario);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/detalhar/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        try {
            Voluntario voluntario = vs.getVoluntarioById(id);
            return ResponseEntity.ok(voluntario);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Voluntário não encontrado!");
        }
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody Voluntario updateVoluntario) {
        try {
            Voluntario voluntario = vs.updateVoluntarioById(id, updateVoluntario);
            return ResponseEntity.ok(voluntario);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Voluntário não encontrado!");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity deletarVoluntario(@PathVariable Long id) {
        try {
            vs.deleteVoluntarioById(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Voluntário não encontrado!");
        }
    }
}
