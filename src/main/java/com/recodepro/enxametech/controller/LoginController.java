package com.recodepro.enxametech.controller;

import com.recodepro.enxametech.enums.Genero;
import com.recodepro.enxametech.model.Aluno;
import com.recodepro.enxametech.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView("login/login");
        return mv;
    }

    @GetMapping("/registrar")
    public ModelAndView registrar() {
        ModelAndView mv = new ModelAndView("login/register");
        mv.addObject("aluno", new Aluno());
        mv.addObject("generos", Genero.values());
        return mv;
    }

    @PostMapping("/registrar")
    public ModelAndView salvar(Aluno aluno) {
        ModelAndView mv = new ModelAndView("redirect:/dashboard");
        alunoRepository.save(aluno);
        return mv;
    }
}