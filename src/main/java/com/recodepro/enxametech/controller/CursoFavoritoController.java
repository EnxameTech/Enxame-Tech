//package com.recodepro.enxametech.controller;
//
//import com.recodepro.enxametech.model.Aluno;
//import com.recodepro.enxametech.model.Curso;
//import com.recodepro.enxametech.model.CursoFavorito;
//import com.recodepro.enxametech.repository.AlunoRepository;
//import com.recodepro.enxametech.repository.CursoFavoritoRepository;
//import com.recodepro.enxametech.repository.CursoRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.List;
//
//@Controller
//@RequestMapping("/cursofavorito")
//public class CursoFavoritoController {
//
//    @Autowired
//    private CursoFavoritoRepository cursoFavoritoRepository;
//
//    @Autowired
//    private CursoRepository cursoRepository;
//
//    @Autowired
//    private AlunoRepository alunoRepository;
//
//    @GetMapping("/listarPorAluno")
//    public ModelAndView listarPorAluno(@RequestParam(name = "alunoId") Integer alunoId) {
//        Aluno aluno = alunoRepository.findById(alunoId).orElse(null);
//
//        List<CursoFavorito> cursosFavoritos = (List<CursoFavorito>) cursoFavoritoRepository.findById_aluno(aluno);
//
//        ModelAndView mv = new ModelAndView("cursofavorito/listar-por-aluno");
//        mv.addObject("aluno", aluno);
//        mv.addObject("cursosFavoritos", cursosFavoritos);
//        mv.addObject("cursos", cursoRepository.findAll());
//        mv.addObject("alunos", alunoRepository.findAll());
//
//        return mv;
//    }
//
//    @GetMapping("/listarPorCurso")
//    public ModelAndView listarPorCurso(@RequestParam(name = "cursoId") Long cursoId) {
//        Curso curso = cursoRepository.findById(cursoId).orElse(null);
//
//        List<CursoFavorito> cursosFavoritos = (List<CursoFavorito>) cursoFavoritoRepository.findById_curso(curso);
//
//        ModelAndView mv = new ModelAndView("cursofavorito/listar-por-curso");
//        mv.addObject("curso", curso);
//        mv.addObject("cursosFavoritos", cursosFavoritos);
//        mv.addObject("cursos", cursoRepository.findAll());
//        mv.addObject("alunos", alunoRepository.findAll());
//
//        return mv;
//    }
//
//}
