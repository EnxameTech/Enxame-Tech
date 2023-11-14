package com.recodepro.enxametech.controller;

import com.recodepro.enxametech.model.Aluno;
import com.recodepro.enxametech.model.Curso;
import com.recodepro.enxametech.model.CursoFavorito;
import com.recodepro.enxametech.repository.AlunoRepository;
import com.recodepro.enxametech.repository.CursoFavoritoRepository;
import com.recodepro.enxametech.repository.CursoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Controller
public class CursoFavoritoController {

    @Autowired
    private CursoFavoritoRepository cursoFavoritoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping("/cursos-favoritos")
    public String listarTodos(Model model) {
        List<CursoFavorito> cursosFavoritos = cursoFavoritoRepository.findAll();
        model.addAttribute("cursosFavoritos", cursosFavoritos);
        return "cursos-favoritos";
    }

    @GetMapping("/cursos-favoritos/{id}")
    public String buscarPorId(@PathVariable Long id, Model model) {
        CursoFavorito cursoFavorito = cursoFavoritoRepository.findById(id).orElse(null);
        if (cursoFavorito != null) {
            model.addAttribute("cursoFavorito", cursoFavorito);
            return "curso-favorito";
        } else {
            return "redirect:/cursos-favoritos";
        }
    }

    @PostMapping("/cursos-favoritos")
    public String salvar(@ModelAttribute CursoFavorito cursoFavorito) {
        cursoFavoritoRepository.save(cursoFavorito);
        return "redirect:/cursos-favoritos";
    }

    @PutMapping("/cursos-favoritos")
    public String atualizar(@ModelAttribute CursoFavorito cursoFavorito) {
        cursoFavoritoRepository.save(cursoFavorito);
        return "redirect:/cursos-favoritos";
    }

    @DeleteMapping("/cursos-favoritos/{id}")
    public String excluir(@PathVariable Long id) {
        cursoFavoritoRepository.deleteById(id);
        return "redirect:/cursos-favoritos";
    }

    @GetMapping("/cursos/{id}/favoritos")
    public String listarFavoritosPorCurso(@PathVariable Long id, Model model) {
        Curso curso = cursoRepository.findById(id).orElse(null);
        if (curso != null) {
            int qtdFavoritos = cursoFavoritoRepository.findByCursoId(id).size();
            model.addAttribute("qtdFavoritos", qtdFavoritos);
            return "cursos-favoritos";
        } else {
            return "redirect:/cursos";
        }
    }

    @GetMapping("/alunos/{id}/favoritos")
    public String listarFavoritosPorAluno(@PathVariable Long id, Model model) {
        Aluno aluno = alunoRepository.findById(id).orElse(null);
        if (aluno != null) {
            List<CursoFavorito> cursosFavoritos = cursoFavoritoRepository.findByAlunoId(id);
            model.addAttribute("cursosFavoritos", cursosFavoritos);
            return "cursos-favoritos";
        } else {
            return "redirect:/alunos";
        }
    }
}
