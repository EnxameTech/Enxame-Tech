package com.recodepro.enxametech.model;

import com.recodepro.enxametech.enums.AreaDeAfinidade;
import jakarta.persistence.*;

@Entity
public class Voluntario extends Usuario{

    @Column(name = "area_deAfinidade")
    @Enumerated(EnumType.STRING)
    private AreaDeAfinidade area_deAfinidade;

    public AreaDeAfinidade getAreaDeAfinidade() {
        return area_deAfinidade;
    }
    public void setAreaDeAfinidade(AreaDeAfinidade area_deAfinidade) {
        this.area_deAfinidade = area_deAfinidade;
    }
}
