package com.recodepro.enxametech.exceptions.administrador;

public class AdministradorAlreadyExistsException extends AdministradorException {

    public AdministradorAlreadyExistsException(String cpf) {
        super("Administrador com cpf " + cpf + " já existe.");
    }
    
}
