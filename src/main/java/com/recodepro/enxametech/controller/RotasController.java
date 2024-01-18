package com.recodepro.enxametech.controller;

<<<<<<< HEAD
import com.recodepro.enxametech.enums.Genero;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
=======
import org.springframework.stereotype.Controller;
>>>>>>> e0ab8d189aae9e052f6a408a197ed34635bd7efc
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RotasController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login/login";
    }

    @GetMapping("/cadastro")
    public String cadastro() {
        return "login/register";
    }

    @GetMapping("/cadastrar-admin")
    public String cadastrarAdmin() {
        return "admin/cadastro-admin";
    }

    @GetMapping("/listar-admin")
    public String listarAdmin() {
        return "admin/listar-admin";
    }

    @GetMapping("/editar-admin")
    public String editarAdmin() {
        return "admin/editar-admin";
    }

    @GetMapping("/cadastrar-curso")
    public String cadastrarCurso() {
        return "curso/cadastro-curso";
    }

    @GetMapping("/listar-cursos")
    public String listarCursos() {
        return "curso/listar-cursos";
    }

    @GetMapping("/editar-curso")
    public String editarCurso() {
        return "curso/editar-curso";
    }

    @GetMapping("/cursos")
    public String cursos() {
        return "cursos-cards/courses";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard/dashboard-home";
    }

    @GetMapping("/fale-conosco")
    public String faleConosco() {
        return "faleConosco/contact";
    }

    @GetMapping("/fale-conosco/enviado")
    public String faleConoscoEnviado() {
        return "faleConosco/enviado";
    }

    @GetMapping("/mentores")
    public String mentores() {
        return "mentores/teachers";
    }

    @GetMapping("/sobre-nos")
    public String sobreNos() {
        return "sobreNos/about-us";
    }

    @GetMapping("/voluntarios")
    public String voluntarios() {
        return "voluntario/listar-voluntarios";
    }

    @GetMapping("/cadastrar-voluntario")
    public String cadastrarVoluntario() {
        return "voluntario/cadastro-voluntario";
    }

    @GetMapping("/editar-voluntario")
    public String editarVoluntario() {
        return "voluntario/editar-voluntario";
    }

    @GetMapping("/form-administrador")
    public String formAdm(Model model) {

        model.addAttribute("generos", Genero.values());
        return "admin/cadastro-admin"; // Isso corresponde ao nome do seu arquivo HTML (index.html)

    }


}
