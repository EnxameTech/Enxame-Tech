package com.recodepro.enxametech.exceptions.aluno;

public class AlunoNotFoundException extends AlunoException {
    
    public AlunoNotFoundException(Long id) {
        super("Aluno com id " + id + " não existe.");
    }

}
