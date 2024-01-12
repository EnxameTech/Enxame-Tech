package com.recodepro.enxametech.controller;

import com.recodepro.enxametech.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.recodepro.enxametech.model.Curso;

import java.util.List;

@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private final CursoService cs;

    public CursoController(CursoService cs) {
        this.cs = cs;
    }

    @GetMapping("/listar")
    public List<Curso> listar(){
        return cs.getAllCursos();
    }

    @PostMapping("/cadastrar")
    public Curso cadastrar(@RequestBody Curso curso){
        return cs.saveCurso(curso);
    }

    @GetMapping("/detalhar/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        try{
            Curso curso = cs.getCursoById(id);
            return ResponseEntity.ok(curso);
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Curso não encontrado!");
        }
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody Curso updateCurso){
        try{
            Curso curso = cs.updateCurso(id, updateCurso);
            return ResponseEntity.ok(curso);
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Curso não encontrado!");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity deletarCurso(@PathVariable Long id){
        try {
            cs.deleteById(id);
            return ResponseEntity.ok("Curso deletado!");
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Curso não encontrado!");
        }
    }

}
