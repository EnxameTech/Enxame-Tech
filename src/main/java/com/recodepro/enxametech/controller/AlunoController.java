package com.recodepro.enxametech.controller;

import com.recodepro.enxametech.model.Aluno;
import com.recodepro.enxametech.model.AlunoMonitoriaDTO;
import com.recodepro.enxametech.model.Monitoria;
import com.recodepro.enxametech.service.AlunoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService as;

    @GetMapping("/listar")
    public List<Aluno> listar() {
        return as.getAllAlunos();
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Aluno> cadastrar(@RequestBody Aluno aluno) {

        try{
            Aluno novoAluno = as.saveAluno(aluno);
            return ResponseEntity.ok(novoAluno);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/detalhar/{id}")
    public ResponseEntity<Aluno> detalhar(@PathVariable Long id) {
        try {
            Aluno aluno = as.getAlunoById(id);
            return ResponseEntity.ok(aluno);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Aluno> atualizar(@PathVariable Long id, @RequestBody Aluno updateAluno) {
        try {
            Aluno aluno = as.updateAluno(id, updateAluno);
            return ResponseEntity.ok(aluno);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Aluno> deletarAluno(@PathVariable Long id) {
        try {
            as.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }


    // Monitorias
    @GetMapping("/{id}/monitorias-agendadas")
    public ResponseEntity alunoMonitorias(@PathVariable Long id) {
        try {
            List<Object[]> monitoriasAluno = as.getMonitoriasAluno(id);
            return ResponseEntity.ok(monitoriasAluno);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{id}/agendar-monitoria")
    public ResponseEntity<Monitoria> agendarMonitoria(@PathVariable Long id, @RequestBody AlunoMonitoriaDTO amDTO){
        try{
            amDTO.setAluno_id(id);
            Monitoria novaMonitoria = as.saveMonitoria(amDTO);
            return ResponseEntity.ok(novaMonitoria);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }


    // @GetMapping("/{id}/monitorias")
    // public ModelAndView listarMonitorias(@PathVariable Long id) {
    //     ModelAndView modelAndView = new ModelAndView("aluno/listar-monitorias");
    //     modelAndView.addObject("aluno", alunoRepository.findById(id).orElse(null));
    //     modelAndView.addObject("monitorias",
    //             monitoriaRepository.findByAlunoId(alunoRepository.findById(id).orElse(null).getId()));
    //     return modelAndView;
    // }

    // @GetMapping("/{id}/agendar")
    // public ModelAndView agendarMonitoria(@PathVariable Long id) {
    //     ModelAndView modelAndView = new ModelAndView("aluno/agendar-monitoria");
    //     modelAndView.addObject("monitoria", new Monitoria());
    //     modelAndView.addObject("aluno", alunoRepository.getReferenceById(id));
    //     modelAndView.addObject("voluntarios", voluntarioRepository.findAll());
    //     return modelAndView;
    // }

    // @PostMapping("/{id}/agendar")
    // public ModelAndView salvarMonitoria(Monitoria monitoria, @PathVariable Long id) {
    //     ModelAndView modelAndView = new ModelAndView("redirect:/aluno/{id}/monitorias");

    //     Voluntario voluntario = voluntarioRepository.findById(monitoria.getVoluntario().getId()).orElse(null);
    //     monitoria.setVoluntario(voluntario);

    //     Aluno aluno = alunoRepository.findById(id).orElse(null);
    //     monitoria.setAluno(aluno);

    //     monitoriaRepository.save(monitoria);
    //     return modelAndView;
    // }

    // // Curso Favorito
    // @GetMapping("/{id}/cursos-favoritos")
    // public ModelAndView listarCursosFavoritos(@PathVariable Long id) {
    //     ModelAndView mv = new ModelAndView("aluno/listar-cursos-favoritos");

    //     Optional<Aluno> alunoOptional = alunoRepository.findById(id);
    //     if (alunoOptional.isPresent()) {
    //         Aluno aluno = alunoOptional.get();
    //         mv.addObject("aluno", aluno);
    //         List<Curso> cursosDisponiveis = cursoRepository.findAll();
    //         mv.addObject("cursosDisponiveis", cursosDisponiveis);
    //         mv.addObject("cursosFavoritos", cursoFavoritoRepository.findByAlunoId(aluno.getId()));
    //     } else {
    //         mv.addObject("erro", "Aluno não encontrado");
    //     }
    //     return mv;
    // }

    // @GetMapping("/{id}/adicionar-curso-favorito")
    // public ModelAndView adicionarCursoFavorito(@PathVariable Long id) {
    //     ModelAndView mv = new ModelAndView("aluno/adicionar-curso-favorito");

    //     Optional<Aluno> alunoOptional = alunoRepository.findById(id);
    //     if (alunoOptional.isPresent()) {
    //         Aluno aluno = alunoOptional.get();
    //         mv.addObject("aluno", aluno);
    //         List<Curso> cursosDisponiveis = cursoRepository.findAll();
    //         mv.addObject("cursosDisponiveis", cursosDisponiveis);
    //     } else {
    //         mv.addObject("erro", "Aluno não encontrado");
    //     }
    //     return mv;
    // }

    // @PostMapping("/{id}/salvar-curso-favorito")
    // public ModelAndView salvarCursoFavorito(@PathVariable Long id, @RequestParam Long cursoFavoritoId) {
    //     Optional<Aluno> alunoOptional = alunoRepository.findById(id);
    //     if (alunoOptional.isPresent()) {
    //         Aluno aluno = alunoOptional.get();

    //         Curso cursoFavorito = cursoRepository.findById(cursoFavoritoId).orElse(null);

    //         if (cursoFavorito != null) {
    //             CursoFavorito cursoFavoritoObj = new CursoFavorito();
    //             cursoFavoritoObj.setCurso(cursoFavorito);

    //             if (!aluno.getCursoFavoritos().contains(cursoFavoritoObj)) {
    //                 aluno.setCursoFavoritos(cursoFavoritoObj);
    //                 alunoRepository.save(aluno);
    //             } else {
    //                 ModelAndView mv = new ModelAndView("aluno/adicionar-curso-favorito");
    //                 mv.addObject("erro", "O curso já está na lista de favoritos");
    //                 mv.addObject("aluno", aluno);
    //                 List<Curso> cursosDisponiveis = cursoRepository.findAll();
    //                 mv.addObject("cursosDisponiveis", cursosDisponiveis);
    //                 return mv;
    //             }
    //         } else {
    //             ModelAndView mv = new ModelAndView("aluno/adicionar-curso-favorito");
    //             mv.addObject("erro", "Curso favorito não encontrado");
    //             mv.addObject("aluno", aluno);
    //             List<Curso> cursosDisponiveis = cursoRepository.findAll();
    //             mv.addObject("cursosDisponiveis", cursosDisponiveis);
    //             return mv;
    //         }
    //     } else {
    //         ModelAndView mv = new ModelAndView("aluno/adicionar-curso-favorito");
    //         mv.addObject("erro", "Aluno não encontrado");
    //         return mv;
    //     }

    //     ModelAndView modelAndView = new ModelAndView("redirect:/aluno/" + id + "/cursos-favoritos");
    //     return modelAndView;
    // }

    // @GetMapping("/{id}/remover-curso-favorito/{cursoFavoritoId}")
    // public ModelAndView removerCursoFavorito(@PathVariable Long id, @PathVariable Long cursoFavoritoId) {
    //     Optional<Aluno> alunoOptional = alunoRepository.findById(id);

    //     if (alunoOptional.isPresent()) {
    //         Aluno aluno = alunoOptional.get();

    //         CursoFavorito cursoFavorito = cursoFavoritoRepository.findById(cursoFavoritoId).orElse(null);

    //         if (cursoFavorito != null) {
    //             aluno.removeCursoFavorito(cursoFavorito);
    //             alunoRepository.save(aluno);
    //             return new ModelAndView("redirect:/aluno/" + id + "/cursos-favoritos");
    //         } else {
    //             ModelAndView mv = new ModelAndView("aluno/listar-cursos-favoritos");
    //             mv.addObject("erro", "Curso favorito não encontrado");
    //             mv.addObject("aluno", aluno);
    //             mv.addObject("cursosFavoritos", cursoFavoritoRepository.findByAlunoId(aluno.getId()));
    //             return mv;
    //         }
    //     } else {
    //         ModelAndView mv = new ModelAndView("aluno/listar-cursos-favoritos");
    //         mv.addObject("erro", "Aluno não encontrado");
    //         return mv;
    //     }
    // }

}
