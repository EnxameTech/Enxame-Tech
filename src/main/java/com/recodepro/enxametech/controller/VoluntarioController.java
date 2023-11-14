package com.recodepro.enxametech.controller;

import com.recodepro.enxametech.enums.AreaDeAfinidade;
import com.recodepro.enxametech.enums.Genero;
import com.recodepro.enxametech.enums.UF;
import com.recodepro.enxametech.model.Voluntario;
import com.recodepro.enxametech.repository.VoluntarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/voluntario")
public class VoluntarioController {

    @Autowired
    private VoluntarioRepository voluntarioRepository;

    @GetMapping
    public ModelAndView listar() {
        ModelAndView modelAndView = new ModelAndView("voluntario/lista_voluntarios");
        modelAndView.addObject("voluntarios", voluntarioRepository.findAll());
        return modelAndView;
    }

    @GetMapping("/{id}/detalhar")
    public ModelAndView detalhesVoluntario(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("voluntario/detalhes");
        modelAndView.addObject("voluntario", voluntarioRepository.getReferenceById(id));
        return modelAndView;
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrarVoluntario() {
        ModelAndView modelAndView = new ModelAndView("voluntario/formulario");
        modelAndView.addObject("voluntario", new Voluntario());
        modelAndView.addObject("areas", AreaDeAfinidade.values());
        modelAndView.addObject("generos", Genero.values());
        modelAndView.addObject("ufs", UF.values());

        return modelAndView;
    }

    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("voluntario/edicao");
        modelAndView.addObject("voluntario", voluntarioRepository.getReferenceById(id));
        modelAndView.addObject("areas", AreaDeAfinidade.values());
        modelAndView.addObject("generos", Genero.values());
        modelAndView.addObject("ufs", UF.values());

        return modelAndView;
    }

    @PostMapping({ "/cadastrar", "/{id}/editar" })
    public ModelAndView salvar(Voluntario voluntario) {
        ModelAndView modelAndView = new ModelAndView("redirect:/voluntario");
        voluntarioRepository.save(voluntario);
        return modelAndView;
    }

    @GetMapping("/{id}/excluir")
    public ModelAndView excluir(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/voluntario");
        voluntarioRepository.deleteById(id);
        return modelAndView;
    }
}
