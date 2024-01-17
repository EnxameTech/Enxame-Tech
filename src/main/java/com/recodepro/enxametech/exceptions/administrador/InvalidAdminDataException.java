package com.recodepro.enxametech.exceptions.administrador;

public class InvalidAdminDataException extends AdministradorException {

    private String fieldName;

    public InvalidAdminDataException(String fieldName, String message) {
        super("Dado inválido no campo '" + fieldName + "': " + message);
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }
}
