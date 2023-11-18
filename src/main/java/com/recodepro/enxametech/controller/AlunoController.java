package com.recodepro.enxametech.controller;

import com.recodepro.enxametech.enums.Genero;
import com.recodepro.enxametech.model.*;
import com.recodepro.enxametech.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/aluno")
public class AlunoController {

    // Injeção de dependência
    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private MonitoriaRepository monitoriaRepository;

    @Autowired
    private VoluntarioRepository voluntarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private CursoFavoritoRepository cursoFavoritoRepository;

    // Alunos
    @GetMapping
    public ModelAndView listar() {
        ModelAndView modelAndView = new ModelAndView("aluno/listar-alunos");
        modelAndView.addObject("alunos", alunoRepository.findAll());
        return modelAndView;
    }

    @GetMapping("/{id}/detalhar")
    public ModelAndView detalhar(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("aluno/detalhar-aluno");
        modelAndView.addObject("aluno", alunoRepository.getReferenceById(id));
        return modelAndView;
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrarAluno() {
        ModelAndView modelAndView = new ModelAndView("aluno/cadastro-aluno");
        modelAndView.addObject("aluno", new Aluno());
        modelAndView.addObject("generos", Genero.values());

        return modelAndView;
    }

    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("aluno/editar-aluno");
        modelAndView.addObject("aluno", alunoRepository.getReferenceById(id));
        modelAndView.addObject("generos", Genero.values());

        return modelAndView;
    }

    @PostMapping({"/cadastrar", "/{id}/editar"})
    public ModelAndView salvar(Aluno aluno) {
        ModelAndView modelAndView = new ModelAndView("redirect:/aluno");
        alunoRepository.save(aluno);
        return modelAndView;
    }

    @GetMapping("/{id}/excluir")
    public ModelAndView excluir(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/aluno");
        alunoRepository.deleteById(id);
        return modelAndView;
    }

    // Monitorias
    @GetMapping("/{id}/monitorias")
    public ModelAndView listarMonitorias(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("aluno/listar-monitorias");
        modelAndView.addObject("aluno", alunoRepository.findById(id).orElse(null));
        modelAndView.addObject("monitorias",
                monitoriaRepository.findByAlunoId(alunoRepository.findById(id).orElse(null).getId()));
        return modelAndView;
    }

    @GetMapping("/{id}/agendar")
    public ModelAndView agendarMonitoria(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("aluno/agendar-monitoria");
        modelAndView.addObject("monitoria", new Monitoria());
        modelAndView.addObject("aluno", alunoRepository.getReferenceById(id));
        modelAndView.addObject("voluntarios", voluntarioRepository.findAll());
        return modelAndView;
    }

    @PostMapping("/{id}/agendar")
    public ModelAndView salvarMonitoria(Monitoria monitoria, @PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/aluno/{id}/monitorias");

        Voluntario voluntario = voluntarioRepository.findById(monitoria.getVoluntario().getId()).orElse(null);
        monitoria.setVoluntario(voluntario);

        Aluno aluno = alunoRepository.findById(id).orElse(null);
        monitoria.setAluno(aluno);

        monitoriaRepository.save(monitoria);
        return modelAndView;
    }

    // Curso Favorito
    @GetMapping("/{id}/cursos-favoritos")
    public ModelAndView listarCursosFavoritos(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("aluno/listar-cursos-favoritos");

        Optional<Aluno> alunoOptional = alunoRepository.findById(id);
        if (alunoOptional.isPresent()) {
            Aluno aluno = alunoOptional.get();
            mv.addObject("aluno", aluno);
            List<Curso> cursosDisponiveis = cursoRepository.findAll();
            mv.addObject("cursosDisponiveis", cursosDisponiveis);
            mv.addObject("cursosFavoritos", cursoFavoritoRepository.findByAlunoId(aluno.getId()));
        } else {
            mv.addObject("erro", "Aluno não encontrado");
        }
        return mv;
    }

    @GetMapping("/{id}/adicionar-curso-favorito")
    public ModelAndView adicionarCursoFavorito(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("aluno/adicionar-curso-favorito");

        Optional<Aluno> alunoOptional = alunoRepository.findById(id);
        if (alunoOptional.isPresent()) {
            Aluno aluno = alunoOptional.get();
            mv.addObject("aluno", aluno);
            List<Curso> cursosDisponiveis = cursoRepository.findAll();
            mv.addObject("cursosDisponiveis", cursosDisponiveis);
        } else {
            mv.addObject("erro", "Aluno não encontrado");
        }
        return mv;
    }

    @PostMapping("/{id}/salvar-curso-favorito")
    public ModelAndView salvarCursoFavorito(@PathVariable Long id, @RequestParam Long cursoFavoritoId) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(id);
        if (alunoOptional.isPresent()) {
            Aluno aluno = alunoOptional.get();

            Curso cursoFavorito = cursoRepository.findById(cursoFavoritoId).orElse(null);

            if (cursoFavorito != null) {
                CursoFavorito cursoFavoritoObj = new CursoFavorito();
                cursoFavoritoObj.setCurso(cursoFavorito);

                if (!aluno.getCursoFavoritos().contains(cursoFavoritoObj)) {
                    aluno.setCursoFavoritos(cursoFavoritoObj);
                    alunoRepository.save(aluno);
                } else {
                    ModelAndView mv = new ModelAndView("aluno/adicionar-curso-favorito");
                    mv.addObject("erro", "O curso já está na lista de favoritos");
                    mv.addObject("aluno", aluno);
                    List<Curso> cursosDisponiveis = cursoRepository.findAll();
                    mv.addObject("cursosDisponiveis", cursosDisponiveis);
                    return mv;
                }
            } else {
                ModelAndView mv = new ModelAndView("aluno/adicionar-curso-favorito");
                mv.addObject("erro", "Curso favorito não encontrado");
                mv.addObject("aluno", aluno);
                List<Curso> cursosDisponiveis = cursoRepository.findAll();
                mv.addObject("cursosDisponiveis", cursosDisponiveis);
                return mv;
            }
        } else {
            ModelAndView mv = new ModelAndView("aluno/adicionar-curso-favorito");
            mv.addObject("erro", "Aluno não encontrado");
            return mv;
        }

        ModelAndView modelAndView = new ModelAndView("redirect:/aluno/" + id + "/cursos-favoritos");
        return modelAndView;
    }

    @GetMapping("/{id}/remover-curso-favorito/{cursoFavoritoId}")
    public ModelAndView removerCursoFavorito(@PathVariable Long id, @PathVariable Long cursoFavoritoId) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(id);

        if (alunoOptional.isPresent()) {
            Aluno aluno = alunoOptional.get();

            CursoFavorito cursoFavorito = cursoFavoritoRepository.findById(cursoFavoritoId).orElse(null);

            if (cursoFavorito != null) {
                aluno.removeCursoFavorito(cursoFavorito);
                alunoRepository.save(aluno);
                return new ModelAndView("redirect:/aluno/" + id + "/cursos-favoritos");
            } else {
                ModelAndView mv = new ModelAndView("aluno/listar-cursos-favoritos");
                mv.addObject("erro", "Curso favorito não encontrado");
                mv.addObject("aluno", aluno);
                mv.addObject("cursosFavoritos", cursoFavoritoRepository.findByAlunoId(aluno.getId()));
                return mv;
            }
        } else {
            ModelAndView mv = new ModelAndView("aluno/listar-cursos-favoritos");
            mv.addObject("erro", "Aluno não encontrado");
            return mv;
        }
    }

}
