package com.recodepro.enxametech.controller;

import com.recodepro.enxametech.model.*;
import com.recodepro.enxametech.service.AlunoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService as;

    @GetMapping("/listar")
    public List<Aluno> listar() {
        return as.getAllAlunos();
    }

    @PostMapping("/cadastrar")
    @ResponseBody
    public ResponseEntity<Aluno> cadastrar(@RequestBody Aluno aluno) {
        try{
            Aluno novoAluno = as.saveAluno(aluno);
            return ResponseEntity.ok(novoAluno);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/detalhar/{id}")
    @ResponseBody
    public ResponseEntity<Aluno> detalhar(@PathVariable Long id) {
        try {
            Aluno aluno = as.getAlunoById(id);
            return ResponseEntity.ok(aluno);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/atualizar/{id}")
    @ResponseBody
    public ResponseEntity<Aluno> atualizar(@PathVariable Long id, @RequestBody Aluno updateAluno) {
        try {
            Aluno aluno = as.updateAluno(id, updateAluno);
            return ResponseEntity.ok(aluno);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Aluno> deletarAluno(@PathVariable Long id) {
        try {
            as.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }


    // Monitorias
    @GetMapping("/{id}/monitorias-agendadas")
    public ResponseEntity<List<Object[]>> alunoMonitorias(@PathVariable Long id) {
        try {
            List<Object[]> monitoriasAluno = as.getMonitoriasAluno(id);
            return ResponseEntity.ok(monitoriasAluno);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{id}/agendar-monitoria")
    public ResponseEntity<Monitoria> agendarMonitoria(@PathVariable Long id, @RequestBody AlunoMonitoriaDTO amDTO){
        try{
            amDTO.setAluno_id(id);
            Monitoria novaMonitoria = as.saveMonitoria(amDTO);
            return ResponseEntity.ok(novaMonitoria);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // Curso Favorito
    @GetMapping("/{id}/cursos-favoritados")
    public ResponseEntity<List<Object[]>> alunoCursosFavs(@PathVariable Long id) {
        try {
            List<Object[]> cursosFavs = as.getCursosFavAluno(id);
            return ResponseEntity.ok(cursosFavs);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{id}/favoritar")
    public ResponseEntity<CursoFavorito> favoritarCurso(@PathVariable Long id, @RequestBody AlunoCursoFavDTO acfDTO){
        try{
            acfDTO.setAluno_id(id);
            CursoFavorito novoCursoFav = as.saveCursoFav(acfDTO);
            return ResponseEntity.ok(novoCursoFav);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
