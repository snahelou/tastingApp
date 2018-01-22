package com.snahelou.rumtasting.controller.dto.enums;

public enum TypeEnum {
    P("Pur Jus"),
    M("Melasse"),
    B("Blend"),
    MU("Muscovado"),
    C("Cachaca");

    private String type;

    TypeEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }
}
