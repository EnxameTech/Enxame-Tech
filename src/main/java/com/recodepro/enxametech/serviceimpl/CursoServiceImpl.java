package com.recodepro.enxametech.serviceimpl;

import com.recodepro.enxametech.model.Curso;
import com.recodepro.enxametech.repository.CursoRepository;
import com.recodepro.enxametech.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository cr;

    @Override
    public List<Curso> getAllCursos() {
        return cr.findAll();
    }

    @Override
    public Curso saveCurso(Curso curso) {
        return cr.save(curso);
    }

    @Override
    public Curso getCursoById(Long id) {
        return cr.findById(id).orElseThrow(()-> new RuntimeException());
    }

    @Override
    public Curso updateCurso(Long id, Curso updateCurso) {
        Curso curso = cr.findById(id).orElseThrow(()-> new RuntimeException());
        curso.setTitulo(updateCurso.getTitulo());
        curso.setNome_empresa(updateCurso.getNome_empresa());
        curso.setDataFinal_inscricao(updateCurso.getDataFinal_inscricao());
        curso.setDescricao(updateCurso.getDescricao());
        return cr.save(curso);
    }

    @Override
    public Curso deleteById(Long id) {
        Curso curso = cr.findById(id). orElseThrow(()-> new RuntimeException());
        cr.deleteById(curso.getId());
        return curso;
    }
}
