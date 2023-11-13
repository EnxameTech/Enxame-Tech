package com.recodepro.enxametech.controller;

import com.recodepro.enxametech.enums.Genero;
import com.recodepro.enxametech.enums.UF;
import com.recodepro.enxametech.model.Administrador;
import com.recodepro.enxametech.repository.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/administrador")
public class AdministradorController {

    @Autowired
    private AdministradorRepository administradorRepository;

    @GetMapping
    public ModelAndView listar(){
        ModelAndView modelAndView = new ModelAndView("administrador/lista_administradores");
        modelAndView.addObject("administradores", administradorRepository.findAll());
        return modelAndView;
    }

    @GetMapping("/{id}/detalhar")
    public ModelAndView detalhesAdministrador( @PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("administrador/detalhes");
        modelAndView.addObject("administrador", administradorRepository.getOne(id));
        return modelAndView;
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrarAdminitrador(){
        ModelAndView modelAndView = new ModelAndView("administrador/formulario");
        modelAndView.addObject("administrador", new Administrador());
        modelAndView.addObject("generos", Genero.values());
        modelAndView.addObject("ufs", UF.values());

        return modelAndView;
    }

    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("administrador/edicao");
        modelAndView.addObject("administrador", administradorRepository.getOne(id));
        modelAndView.addObject("generos", Genero.values());
        modelAndView.addObject("ufs", UF.values());

        return modelAndView;
    }

    @PostMapping({"/cadastrar", "/{id}/editar"})
    public ModelAndView salvar(Administrador administrador){
        ModelAndView modelAndView = new ModelAndView("redirect:/administrador");
        administradorRepository.save(administrador);
        return modelAndView;
    }

    @GetMapping("/{id}/excluir")
    public ModelAndView excluir (@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("redirect:/administrador");
        administradorRepository.deleteById(id);
        return modelAndView;
    }
}
