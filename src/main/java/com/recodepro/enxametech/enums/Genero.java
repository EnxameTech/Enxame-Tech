package com.recodepro.enxametech.enums;

public enum Genero {
    MASCULINO("Masculino"),
    FEMININO("Feminino"),
    NAO_BINARIO("Não-Binário"),
    OUTRO("Outro"),
    PREFIRO_NAO_RESPONDER("Prefiro não responder");

    private final String descricao;

    Genero(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
