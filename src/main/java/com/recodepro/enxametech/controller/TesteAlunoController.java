package com.recodepro.enxametech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/teste-aluno")
public class TesteAlunoController {

    @GetMapping
    public ModelAndView listar(){
        ModelAndView modelAndView = new ModelAndView("aluno/listar-alunos");
        return modelAndView;
    }

    @GetMapping("/editar")
    public ModelAndView editar(){
        ModelAndView modelAndView = new ModelAndView("aluno/editar-aluno");
        return modelAndView;
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar(){
        ModelAndView modelAndView = new ModelAndView("aluno/cadastro-aluno");
        return modelAndView;
    }
}
