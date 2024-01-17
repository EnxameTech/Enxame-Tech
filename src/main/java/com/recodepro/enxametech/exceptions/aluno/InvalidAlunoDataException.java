package com.recodepro.enxametech.exceptions.aluno;

public class InvalidAlunoDataException extends AlunoException {

    private String fieldName;

    public InvalidAlunoDataException(String fieldName, String message) {
        super("Dado inválido no campo '" + fieldName + "': " + message);
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }

}
