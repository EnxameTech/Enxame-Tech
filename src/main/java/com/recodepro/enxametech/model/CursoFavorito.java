//package com.recodepro.enxametech.model;
//
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "curso_favorito")
//public class CursoFavorito {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "aluno_id")
//    private Aluno aluno;
//
//    @ManyToOne
//    @JoinColumn(name = "curso_id")
//    private Curso curso;
//
//    public CursoFavorito() {
//    }
//
//    public CursoFavorito(Aluno aluno, Curso curso) {
//        this.aluno = aluno;
//        this.curso = curso;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Aluno getAluno() {
//        return aluno;
//    }
//
//    public void setAluno(Aluno aluno) {
//        this.aluno = aluno;
//    }
//
//    public Curso getCurso() {
//        return curso;
//    }
//
//    public void setCurso(Curso curso) {
//        this.curso = curso;
//    }
//}
