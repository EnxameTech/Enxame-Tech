package com.recodepro.enxametech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/mentores")
public class MentoresController {

    public ModelAndView mentores() {
        ModelAndView modelAndView = new ModelAndView("mentores/teachers");
        return modelAndView;
    }

}
