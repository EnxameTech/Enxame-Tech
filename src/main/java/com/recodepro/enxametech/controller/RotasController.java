package com.recodepro.enxametech.controller;

import com.recodepro.enxametech.enums.AreaDeAfinidade;
import com.recodepro.enxametech.enums.Genero;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @GetMapping("/registrar")
    public String cadastro(Model model) {
        model.addAttribute("generos", Genero.values());
        return "login/register";
    }

    @GetMapping("/registrar-voluntario")
    public String cadastroVoluntario(Model model) {
        model.addAttribute("generos", Genero.values());
        model.addAttribute("areas", AreaDeAfinidade.values());
        return "login/register_voluntario";
    }

    // Rotas para o admin
    @GetMapping("/cadastrar-admin")
    public String cadastrarAdmin(Model model) {
        model.addAttribute("generos", Genero.values());
        return "admin/cadastro-admin";
    }

    @GetMapping("/listar-admin")
    public String listarAdmin() {
        return "admin/listar-admin";
    }

    @GetMapping("/editar-admin")
    public String editarAdmin(Model model) {
        model.addAttribute("generos", Genero.values());
        return "admin/editar-admin";
    }

    // Rotas para o aluno
    @GetMapping("/cadastrar-aluno")
    public String cadastrarAluno(Model model) {
        model.addAttribute("generos", Genero.values());
        return "aluno/cadastro-aluno";
    }

    @GetMapping("/listar-alunos")
    public String listarAlunos() {
        return "aluno/listar-alunos";
    }

    @GetMapping("/editar-aluno")
    public String editarAluno(Model model) {
        model.addAttribute("generos", Genero.values());
        return "aluno/editar-aluno";
    }

    // Cursos favoritos
    @GetMapping("/aluno/adicionar-curso-favorito")
    public String adicionarCursoFavorito() {
        return "aluno/adicionar-curso-favorito";
    }

    @GetMapping("/aluno/listar-cursos-favoritos")
    public String listarCursosFavoritos() {
        return "aluno/listar-cursos-favoritos";
    }

    // Rotas para curso
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

    @GetMapping("/cursos-disponiveis")
    public String cursosCards() {
        return "cursos-cards/courses";
    }

    // Rotas para o dashboard
    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard/dashboard-home";
    }

    // Rotas para o fale conosco
    @GetMapping("/fale-conosco")
    public String faleConosco() {
        return "faleConosco/contact";
    }

    @GetMapping("/fale-conosco/enviado")
    public String faleConoscoEnviado() {
        return "faleConosco/enviado";
    }

    // Rotas para o mentor
    @GetMapping("/mentores")
    public String mentores() {
        return "mentores/teachers";
    }

    // Rotas para o sobre nós
    @GetMapping("/sobre-nos")
    public String sobreNos() {
        return "sobreNos/about-us";
    }

    // Rotas para o voluntário
    @GetMapping("/listar-voluntarios")
    public String voluntarios() {
        return "voluntario/listar-voluntarios";
    }

    @GetMapping("/cadastrar-voluntario")
    public String cadastrarVoluntario(Model model) {
        model.addAttribute("generos", Genero.values());
        model.addAttribute("areas", AreaDeAfinidade.values());
        return "voluntario/cadastro-voluntario";
    }

    @GetMapping("/editar-voluntario")
    public String editarVoluntario(Model model) {
        model.addAttribute("generos", Genero.values());
        model.addAttribute("areas", AreaDeAfinidade.values());
        return "voluntario/editar-voluntario";
    }
}
