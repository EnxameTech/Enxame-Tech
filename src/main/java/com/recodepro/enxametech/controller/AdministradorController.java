package com.recodepro.enxametech.controller;

import com.recodepro.enxametech.model.Administrador;
import com.recodepro.enxametech.service.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/administrador")
public class AdministradorController {

    @Autowired
    private AdministradorService as;

    @GetMapping("/listar")
    public List<Administrador> listar(){
        return as.getAllAdms();
    }

    @PostMapping("/cadastrar")
    public Administrador cadastrar(@RequestBody Administrador adm){
        return as.saveAdm(adm);
    }

    @GetMapping("/detalhar/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        try{
            Administrador adm = as.getAdmById(id);
            return ResponseEntity.ok(adm);
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Administrador não encontrado!");
        }
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody Administrador updateAdm){
        try{
            Administrador adm = as.updateAdm(id, updateAdm);
            return ResponseEntity.ok(adm);
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Administrador não encontrado!");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity deletarAdm(@PathVariable Long id){
        try {
            as.deleteById(id);
            return ResponseEntity.ok("Administrador deletado!");
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Administrador não encontrado!");
        }
    }
}
