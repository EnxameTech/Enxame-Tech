package com.recodepro.enxametech.controller;

import com.recodepro.enxametech.model.Administrador;
import com.recodepro.enxametech.service.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @ResponseBody
    public ResponseEntity<Administrador> cadastrar(@RequestBody Administrador adm){
        try {
            Administrador novoAdm = as.saveAdm(adm);
            return ResponseEntity.ok(novoAdm);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/detalhar/{id}")
    public ResponseEntity<Administrador> detalhar(@PathVariable Long id){
        try{
            Administrador adm = as.getAdmById(id);
            return ResponseEntity.ok(adm);
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Administrador> atualizar(@PathVariable Long id, @RequestBody Administrador updateAdm){
        try{
            Administrador adm = as.updateAdm(id, updateAdm);
            return ResponseEntity.ok(adm);
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Administrador> deletarAdm(@PathVariable Long id){
        try {
            as.deleteById(id);
            return ResponseEntity.ok().build();
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }
}
