package com.recodepro.enxametech.controller;

import com.recodepro.enxametech.enums.Genero;
import com.recodepro.enxametech.enums.UF;
import com.recodepro.enxametech.model.Administrador;
import com.recodepro.enxametech.repository.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public ModelAndView listar() {
        ModelAndView modelAndView = new ModelAndView("admin/listar-admin");
        modelAndView.addObject("administradores", administradorRepository.findAll());
        return modelAndView;
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrarAdminitrador() {
        ModelAndView modelAndView = new ModelAndView("admin/cadastro-admin");
        modelAndView.addObject("administrador", new Administrador());
        modelAndView.addObject("generos", Genero.values());
        modelAndView.addObject("ufs", UF.values());

        return modelAndView;
    }

    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("admin/editar-admin");
        modelAndView.addObject("administrador", administradorRepository.getReferenceById(id));
        modelAndView.addObject("generos", Genero.values());
        modelAndView.addObject("ufs", UF.values());

        return modelAndView;
    }

    @PostMapping({ "/cadastrar", "/{id}/editar" })
    public ModelAndView salvar(Administrador administrador) {
        ModelAndView modelAndView = new ModelAndView("redirect:/administrador");
        administradorRepository.save(administrador);
        return modelAndView;
    }

    @GetMapping("/{id}/excluir")
    public ModelAndView excluir(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/administrador");
        administradorRepository.deleteById(id);
        return modelAndView;
    }
}
