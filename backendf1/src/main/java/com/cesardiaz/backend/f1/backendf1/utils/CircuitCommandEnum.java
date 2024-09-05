package com.cesardiaz.backend.f1.backendf1.utils;

public enum CircuitCommandEnum {
    circuits_available("circuits_avaible"), circuits_seasson("circuits_seassson");
    private String code;

    CircuitCommandEnum(String code){
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
}
