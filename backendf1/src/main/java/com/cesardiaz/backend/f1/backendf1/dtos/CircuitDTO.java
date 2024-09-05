package com.cesardiaz.backend.f1.backendf1.dtos;

import java.time.LocalDate;

import com.cesardiaz.backend.f1.backendf1.models.CodeValue;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CircuitDTO {

    private String name;
    private CodeValueDto codeValueCountry;
    private String datecreated;
    private String dateUpdated;
    private Integer numberLaps;
    private RecordFastlapDTO recordFastlapDTO;


    public CircuitDTO(String name, CodeValueDto codeValueCountry, String datecreated, String dateUpdated) {
        this.name = name;
        this.codeValueCountry = codeValueCountry;
        this.datecreated = datecreated;
        this.dateUpdated = dateUpdated;
    }

    public CircuitDTO(final String name, final CodeValueDto codeValueCountry, final String datecreated, final String dateUpdated, final Integer numberLaps, final RecordFastlapDTO recordFastlapDTO) {
        this.name = name;
        this.codeValueCountry = codeValueCountry;
        this.datecreated = datecreated;
        this.dateUpdated = dateUpdated;
        this.numberLaps = numberLaps;
        this.recordFastlapDTO = recordFastlapDTO;
    }
    public CircuitDTO(final String name, final CodeValueDto codeValueCountry, final Integer numberLaps, final RecordFastlapDTO recordFastlapDTO) {
        this.name = name;
        this.codeValueCountry = codeValueCountry;
        this.numberLaps = numberLaps;
        this.recordFastlapDTO = recordFastlapDTO;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public CodeValueDto getCodeValueCountry() {
        return codeValueCountry;
    }
    public void setCodeValueCountry(CodeValueDto codeValueCountry) {
        this.codeValueCountry = codeValueCountry;
    }
    public String getDatecreated() {
        return datecreated;
    }
    public void setDatecreated(String datecreated) {
        this.datecreated = datecreated;
    }
    public String getDateUpdated() {
        return dateUpdated;
    }
    public void setDateUpdated(String dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public Integer getNumberLaps() {
        return numberLaps;
    }

    public void setNumberLaps(Integer numberLaps) {
        this.numberLaps = numberLaps;
    }

    public RecordFastlapDTO getRecordFastlapDTO() {
        return recordFastlapDTO;
    }

    public void setRecordFastlapDTO(RecordFastlapDTO recordFastlapDTO) {
        this.recordFastlapDTO = recordFastlapDTO;
    }

    
}
