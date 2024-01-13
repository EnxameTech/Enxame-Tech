package com.recodepro.enxametech.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.recodepro.enxametech.model.Voluntario;
import com.recodepro.enxametech.repository.VoluntarioRepository;
import com.recodepro.enxametech.service.VoluntarioService;

public class VoluntarioServiceImpl implements VoluntarioService {

    @Autowired
    private VoluntarioRepository vr;

    @Override
    public List<Voluntario> getAllVoluntarios() {
        return vr.findAll();
    }

    @Override
    public Voluntario saveVoluntario(Voluntario voluntario) {
        return vr.save(voluntario);
    }

    @Override
    public Voluntario getVoluntarioById(long id) {
        return vr.findById(id).orElseThrow(()-> new RuntimeException());
    }

    @Override
    public Voluntario updateVoluntarioById(long id, Voluntario voluntario) {
        Voluntario vol = vr.findById(id).orElseThrow(()-> new RuntimeException());

        // campos com informações pessoais
        vol.setNome_completo(voluntario.getNome_completo());
        vol.setData_nascimento(voluntario.getData_nascimento());
        vol.setEmail(voluntario.getEmail());
        vol.setSenha(voluntario.getSenha());
        vol.setGenero(voluntario.getGenero());
        vol.setTelefone(voluntario.getTelefone());
        vol.setCPF(voluntario.getCPF());

        // campos de endereço
        vol.setRua(voluntario.getRua());
        vol.setNumero(voluntario.getNumero());
        vol.setBairro(voluntario.getBairro());
        vol.setCidade(voluntario.getCidade());
        vol.setUF(voluntario.getUF());
        vol.setCEP(voluntario.getCEP());

        return vr.save(vol);
    }

    @Override
    public void deleteVoluntarioById(long id) {
        Voluntario vol = vr.findById(id).orElseThrow(()-> new RuntimeException());
        vr.deleteById(vol.getId());
    }
    
    
}
