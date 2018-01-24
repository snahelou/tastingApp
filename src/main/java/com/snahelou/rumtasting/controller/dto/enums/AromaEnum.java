package com.snahelou.rumtasting.controller.dto.enums;

public enum AromaEnum {
    V("Vegetal"),
    Fl("Floral"),
    Fr("Fruit"),
    W("Wooded"),
    Su("Sugar"),
    Sp("Spicy"),
    C("Cake"),
    E("Empyreumatic");

    private String aroma;

    AromaEnum(String aroma){
        this.aroma = aroma;
    }

    public String getAroma(){
        return this.aroma;
    }

    public static AromaEnum fromString(String s) {
        for (AromaEnum aroma : values()) {
            if (aroma.toString().equals(s)) {
                return aroma;
            }
        }
        return null;
    }
}
