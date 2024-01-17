package com.recodepro.enxametech.exceptions.administrador;

public class AdministratorNotFoundException extends AdministradorException {

    public AdministratorNotFoundException(Long id) {
        super("Administrador com id " + id + " não encontrado.");
    }
    
}
