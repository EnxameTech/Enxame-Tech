package com.recodepro.enxametech.exceptions.aluno;

public class AlunoException extends RuntimeException {
    
    public AlunoException(String message) {
        super(message);
    }

    public AlunoException(String message, Throwable cause) {
        super(message, cause);
    }

    public AlunoException(Throwable cause) {
        super(cause);
    }

}
