package com.recodepro.enxametech.serviceimpl;

import java.util.List;

import com.recodepro.enxametech.model.*;
import com.recodepro.enxametech.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recodepro.enxametech.service.AlunoService;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class AlunoServiceImpl implements AlunoService {

    @Autowired
    private AlunoRepository ar;

    @Autowired
    private VoluntarioRepository vr;

    @Autowired
    private MonitoriaRepository mr;

    @Autowired
    private CursoRepository cr;

    @Autowired
    private CursoFavoritoRepository cfr;

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


    //Monitoria
    @Override
    public List<Object[]> getMonitoriasAluno(Long id) {
        Aluno aluno = ar.findById(id).orElseThrow(()-> new RuntimeException());
        List<Object[]> monitorias = ar.getMonitoriasAluno(aluno.getId());

        return monitorias;
    }

    @Override
    public Monitoria saveMonitoria(AlunoMonitoriaDTO amDTO) {
        Monitoria monitoria = new Monitoria();
        monitoria.setAluno(ar.findById(amDTO.getAluno_id()).orElseThrow(()-> new RuntimeException()));
        monitoria.setVoluntario(vr.findById(amDTO.getVoluntario_id()).orElseThrow(()-> new RuntimeException()));
        monitoria.setDescricao_duvida(amDTO.getDescricao_duvida());
        monitoria.setData_monitoria(amDTO.getData_monitoria());
        monitoria.setHorario(amDTO.getHorario());

        return mr.save(monitoria);
    }


    //Curso Favorito
    @Override
    public List<Object[]> getCursosFavAluno(Long id) {
        Aluno aluno = ar.findById(id).orElseThrow(()-> new RuntimeException());
        List<Object[]> cursosFavs = ar.getCursoFavAluno(aluno.getId());

        return cursosFavs;
    }

    @Override
    public CursoFavorito saveCursoFav(AlunoCursoFavDTO acfDTO) {
        CursoFavorito cursoFav = new CursoFavorito();
        cursoFav.setAluno(ar.findById(acfDTO.getAluno_id()).orElseThrow(()-> new RuntimeException()));
        cursoFav.setCurso(cr.findById(acfDTO.getCurso_id()).orElseThrow(()-> new RuntimeException()));

        return cfr.save(cursoFav);
    }
}
