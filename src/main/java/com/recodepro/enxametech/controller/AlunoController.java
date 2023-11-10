package com.recodepro.enxametech.controller;

import com.recodepro.enxametech.enums.Genero;
import com.recodepro.enxametech.enums.UF;
import com.recodepro.enxametech.model.Aluno;
import com.recodepro.enxametech.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping
    public ModelAndView listar(){
        ModelAndView modelAndView = new ModelAndView("aluno/lista_alunos");
        modelAndView.addObject("alunos", alunoRepository.findAll());
        return modelAndView;
    }

    @GetMapping("/{id}/detalhar")
    public ModelAndView detalhesAluno( @PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("aluno/detalhes");
        modelAndView.addObject("aluno", alunoRepository.getOne(id));
        return modelAndView;
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrarAluno(){
        ModelAndView modelAndView = new ModelAndView("aluno/formulario");
        modelAndView.addObject("aluno", new Aluno());
        modelAndView.addObject("generos", Genero.values());
        modelAndView.addObject("ufs", UF.values());

        return modelAndView;
    }

    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("aluno/edicao");
        modelAndView.addObject("aluno", alunoRepository.getOne(id));
        modelAndView.addObject("generos", Genero.values());
        modelAndView.addObject("ufs", UF.values());

        return modelAndView;
    }

    @PostMapping({"/cadastrar", "/{id}/editar"})
    public ModelAndView salvar(Aluno aluno){
        ModelAndView modelAndView = new ModelAndView("redirect:/aluno");
        alunoRepository.save(aluno);
        return modelAndView;
    }

    @GetMapping("/{id}/excluir")
    public ModelAndView excluir (@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("redirect:/aluno");
        alunoRepository.deleteById(id);
        return modelAndView;
    }
}
