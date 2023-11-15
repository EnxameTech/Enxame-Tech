package com.recodepro.enxametech.controller;

import com.recodepro.enxametech.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.recodepro.enxametech.model.Curso;

import java.util.Optional;

@Controller
public class CursoController {

    @Autowired
    private final CursoRepository cursoRepository;

    public CursoController(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @GetMapping("/cursos")
    public ModelAndView todosCursos() {
        ModelAndView mv = new ModelAndView("cursos/lista_cursos");

        mv.addObject("curso", cursoRepository.findAll());
        return mv;
    }

    @GetMapping("/cursos/cadastrarCurso")
    public ModelAndView cadastrarCurso() {
        ModelAndView mv = new ModelAndView("cursos/formulario");
        mv.addObject("curso", new Curso());
        return mv;
    }

    @GetMapping("/cursos/{id}/editar")
    public ModelAndView editar(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("cursos/formulario");
        mv.addObject("curso", cursoRepository.getReferenceById(id));
        return mv;
    }

    @PostMapping({ "/cursos/cadastrar", "/cursos/{id}/editar" })
    public String salvar(Curso curso) {
        cursoRepository.save(curso);
        return "redirect:/cursos";
    }

}
