package com.cesardiaz.backend.f1.backendf1.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@NamedQuery(name = "CodeValue.findAll", query = "SELECT cv FROM CodeValue cv")
@Table(name = "code_value")
public class CodeValue extends AbstractPersistableCustom<Long>{

    @ManyToOne
    @JoinColumn(name = "code_id", nullable = false)
    private Code code;

    @Column(name= "code_value", nullable = false)
    private String codeValue;

    
    public CodeValue(Long id, Code code, String codeValue) {
        setId(id);
        this.code = code;
        this.codeValue = codeValue;
    }

    public CodeValue(Code code, String codeValue) {
        this.code = code;
        this.codeValue = codeValue;
    }


    public CodeValue(String codeValue) {
        this.codeValue = codeValue;
    }    
    

    public String getCodeValue() {
        return codeValue;
    }

    public void setCodeValue(String codeValue) {
        this.codeValue = codeValue;
    }


    public Code getCode() {
        return code;
    }


    public void setCodeId(Code code) {
        this.code = code;
    }

    
}
