package com.recodepro.enxametech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/sobre-nos")
public class SobreNosController {

    @GetMapping
    public ModelAndView sobreNos() {
        ModelAndView modelAndView = new ModelAndView("sobreNos/about-us");
        return modelAndView;
    }

}
