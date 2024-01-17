package com.recodepro.enxametech.exceptions.aluno;

public class AlunoAlreadyExistsException extends AlunoException {

    public AlunoAlreadyExistsException(Long id) {
        super("Aluno com id " + id + " já existe.");
    }
    
}
