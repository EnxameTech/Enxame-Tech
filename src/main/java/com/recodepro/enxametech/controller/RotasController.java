package com.recodepro.enxametech.controller;

import com.recodepro.enxametech.enums.Genero;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RotasController {

    @GetMapping("/form-administrador")
    public String formAdm(Model model) {

        model.addAttribute("generos", Genero.values());
        return "admin/cadastro-admin"; // Isso corresponde ao nome do seu arquivo HTML (index.html)

    }
}
