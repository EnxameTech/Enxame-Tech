package com.recodepro.enxametech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cursos-disponiveis")
public class CursosDisponiveisController {

    @GetMapping
    public ModelAndView cursosDisponiveis() {
        ModelAndView modelAndView = new ModelAndView("cursos-cards/courses");
        return modelAndView;
    }

}
