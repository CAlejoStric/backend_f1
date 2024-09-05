package com.cesardiaz.backend.f1.backendf1.dtos;

public class CodeValueDto {
    private Long id;
    private String code;
    private Long codeId;

    public CodeValueDto(Long id, String code, Long codeId){
        this.id = id;
        this.code = code;
        this.codeId = codeId;
    }
}
