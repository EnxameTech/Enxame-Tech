package com.recodepro.enxametech.enums;

public enum AreaDeAfinidade {
    FRONT_END("Front-End"),
    BACK_END("Back-End"),
    LOGICA_DE_PROGRAMACAO("Lógica de Programação"),
    BANCO_DE_DADOS("Bando de Dados");

    private final String descricao;

    AreaDeAfinidade(String descricao){
        this.descricao=descricao;
    }

    public String getDescricao(){
        return descricao;
    }
}
