//package com.recodepro.enxametech.model;
//
//import jakarta.persistence.*;
//
//@Entity
//public class CursoFavorito {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id_curso_favorito;
//
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn
//    private Aluno id_aluno;
//
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn
//    private Curso id_curso;
//
//    public Long getId_curso_favorito() {
//        return id_curso_favorito;
//    }
//    public void setId_curso_favorito(Long id_curso_favorito) {
//        this.id_curso_favorito = id_curso_favorito;
//    }
//
//    public Aluno getId_aluno() {
//        return id_aluno;
//    }
//    public void setId_aluno(Aluno id_aluno) {
//        this.id_aluno = id_aluno;
//    }
//
//    public Curso getId_curso() {
//        return id_curso;
//    }
//    public void setId_curso(Curso id_curso) {
//        this.id_curso = id_curso;
//    }
//}
