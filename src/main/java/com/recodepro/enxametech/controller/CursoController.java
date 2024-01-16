package com.recodepro.enxametech.controller;

import com.recodepro.enxametech.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.recodepro.enxametech.model.Curso;

import java.util.List;

@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private CursoService cs;

    @GetMapping("/listar")
    public List<Curso> listar(){
        return cs.getAllCursos();
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Curso> cadastrar(@RequestBody Curso curso){
        try {
            Curso novoCurso = cs.saveCurso(curso);
            return ResponseEntity.ok(novoCurso);
        } catch (RuntimeException e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/detalhar/{id}")
    public ResponseEntity<Curso> detalhar(@PathVariable Long id){
        try{
            Curso curso = cs.getCursoById(id);
            return ResponseEntity.ok(curso);
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Curso> atualizar(@PathVariable Long id, @RequestBody Curso updateCurso){
        try{
            Curso curso = cs.updateCurso(id, updateCurso);
            return ResponseEntity.ok(curso);
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Curso> deletarCurso(@PathVariable Long id){
        try {
            cs.deleteById(id);
            return ResponseEntity.ok().build();
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

}
