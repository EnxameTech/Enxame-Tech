package com.recodepro.enxametech.exceptions.administrador;

public class AdministradorException extends RuntimeException {
    
    public AdministradorException(String message) {
        super(message);
    }

    public AdministradorException(String message, Throwable cause) {
        super(message, cause);
    }

    public AdministradorException(Throwable cause) {
        super(cause);
    }
}
