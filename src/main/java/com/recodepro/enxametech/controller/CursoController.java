package com.recodepro.enxametech.controller;

import com.recodepro.enxametech.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.recodepro.enxametech.model.Curso;

import java.util.Optional;

@Controller
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private final CursoRepository cursoRepository;

    public CursoController(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @GetMapping
    public ModelAndView listarCursos() {
        ModelAndView mv = new ModelAndView("curso/listar-cursos");
        mv.addObject("cursos", cursoRepository.findAll());
        return mv;
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrarCurso() {
        ModelAndView mv = new ModelAndView("curso/cadastro-curso");
        mv.addObject("curso", new Curso());
        return mv;
    }

    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("curso/editar-curso");
        mv.addObject("curso", cursoRepository.getReferenceById(id));
        return mv;
    }

    @PostMapping({"/cadastrar", "/{id}/editar"})
    public String salvar(Curso curso) {
        cursoRepository.save(curso);
        return "redirect:/curso";
    }

    @GetMapping("/{id}/excluir")
    public ModelAndView excluir(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/curso");
        cursoRepository.deleteById(id);
        return modelAndView;
    }

}
