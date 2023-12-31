package com.recodepro.enxametech.controller;

import com.recodepro.enxametech.model.FaleConosco;
import com.recodepro.enxametech.repository.FaleConoscoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/fale-conosco")
public class FaleConoscoController {

    @Autowired
    private FaleConoscoRepository faleConoscoRepository;

    @GetMapping
    public ModelAndView faleConosco() {
        ModelAndView modelAndView = new ModelAndView("faleConosco/contact");
        modelAndView.addObject("faleConosco", new FaleConosco());

        return modelAndView;
    }

    @PostMapping
    public ModelAndView faleConosco(FaleConosco faleConosco) {
        ModelAndView modelAndView = new ModelAndView("faleConosco/enviado");
        faleConoscoRepository.save(faleConosco);
        return modelAndView;
    }
}
