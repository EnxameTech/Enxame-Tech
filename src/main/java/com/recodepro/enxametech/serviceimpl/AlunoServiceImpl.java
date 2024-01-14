package com.recodepro.enxametech.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recodepro.enxametech.model.Aluno;
import com.recodepro.enxametech.repository.AlunoRepository;
import com.recodepro.enxametech.service.AlunoService;

@Service
public class AlunoServiceImpl implements AlunoService {

    @Autowired
    private AlunoRepository ar;

    @Override
    public List<Aluno> getAllAlunos() {
        return ar.findAll();
    }

    @Override
    public Aluno saveAluno(Aluno aluno) {
        return ar.save(aluno);
    }

    @Override
    public Aluno getAlunoById(Long id) {
        return ar.findById(id).orElseThrow(()-> new RuntimeException());
    }

    @Override
    public Aluno updateAluno(Long id, Aluno updateAluno) {
        Aluno aluno = ar.findById(id).orElseThrow(()-> new RuntimeException());

        aluno.setNome_completo(updateAluno.getNome_completo());
        aluno.setData_nascimento(updateAluno.getData_nascimento());
        aluno.setEmail(updateAluno.getEmail());
        aluno.setSenha(updateAluno.getSenha());
        aluno.setGenero(updateAluno.getGenero());
        aluno.setTelefone(updateAluno.getTelefone());
        aluno.setRua(updateAluno.getRua());
        aluno.setNumero(updateAluno.getNumero());
        aluno.setBairro(updateAluno.getBairro());
        aluno.setCidade(updateAluno.getCidade());
        aluno.setUF(updateAluno.getUF());
        aluno.setCEP(updateAluno.getCEP());
        aluno.setCPF(updateAluno.getCPF());

        //TODO: aluno.setCursosFavoritos(updateAluno.getCursosFavoritos());
        aluno.setCursoFavoritos(updateAluno.getCursoFavoritos());
        aluno.setGrupo_familiar(updateAluno.getGrupo_familiar());
        aluno.setRenda_familiar(updateAluno.getRenda_familiar());
        aluno.setVoluntarios(updateAluno.getVoluntarios());

        return ar.save(aluno);
    }

    @Override
    public void deleteById(Long id) {
        Aluno aluno = ar.findById(id).orElseThrow(()-> new RuntimeException());
        ar.deleteById(aluno.getId());
    }
    
}
