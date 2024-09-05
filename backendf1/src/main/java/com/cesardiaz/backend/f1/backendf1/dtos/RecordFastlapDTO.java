package com.cesardiaz.backend.f1.backendf1.dtos;

import com.cesardiaz.backend.f1.backendf1.models.ResultRace;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class RecordFastlapDTO {

    private Long id;
    private String recordFastLap;
    // private ResultRace resultRace;
    private CircuitDTO circuitDTO;
    private CodeValueDto codeValueSeassonDto;
    private Integer status;
    private String dateCreated;
    private String dateUpdated;

    public RecordFastlapDTO(String recordFastLap, CircuitDTO circuitDTO,
            CodeValueDto codeValueSeassonDto, Integer status, String dateCreated,
            String dateUpdated) {
        this.recordFastLap = recordFastLap;
        this.circuitDTO = circuitDTO;
        this.codeValueSeassonDto = codeValueSeassonDto;
        this.status = status;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
    }

    public RecordFastlapDTO(Long id, String recordFastLap,
            CodeValueDto codeValueSeassonDto, Integer status) {
        this.id = id;
        this.recordFastLap = recordFastLap;
        this.codeValueSeassonDto = codeValueSeassonDto;
        this.status = status;
    }

    public String getRecordFastLap() {
        return recordFastLap;
    }

    public void setRecordFastLap(String recordFastLap) {
        this.recordFastLap = recordFastLap;
    }

    public CircuitDTO getCircuitDTO() {
        return circuitDTO;
    }

    public void setCircuitDTO(CircuitDTO circuitDTO) {
        this.circuitDTO = circuitDTO;
    }

    public CodeValueDto getCodeValueSeassonDto() {
        return codeValueSeassonDto;
    }

    public void setCodeValueSeassonDto(CodeValueDto codeValueSeassonDto) {
        this.codeValueSeassonDto = codeValueSeassonDto;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(String dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
