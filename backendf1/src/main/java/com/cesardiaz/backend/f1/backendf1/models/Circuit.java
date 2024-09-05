package com.cesardiaz.backend.f1.backendf1.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@NamedQuery(name = "Circuit.findAll", query = "SELECT c FROM Circuit c")
@Table(name = "circuit")
public class Circuit extends AbstractPersistableCustom<Long>{

    @Column(name = "name", nullable = false)
    private String name;
    
    @ManyToOne
    @JoinColumn(name = "code_value_country", nullable = false)
    private CodeValue codeValueCountry;

    @Column(name= "date_created")
    private LocalDate dateCreated;
    
    @Column(name= "date_updated")
    private LocalDate dateUpdated;

    @Column(name= "number_laps")
    private Integer numberLaps;

    @OneToOne
    @JoinColumn(name = "record_fastlap_id", nullable = false)
    private RecordFastLap recordFastLap;
    
    @Column(name= "is_deleted")
    private Boolean isDeleted;

    public Circuit(String name, CodeValue codeValueCountry, LocalDate datecreated, LocalDate dateUpdated, Integer numberLaps, RecordFastLap recordFastLap) {
        this.name = name;
        this.codeValueCountry = codeValueCountry;
        this.dateCreated = datecreated;
        this.dateUpdated = dateUpdated;
        this.numberLaps = numberLaps;
        this.recordFastLap = recordFastLap;
    }

    public Circuit(String name, CodeValue codeValueCountry, LocalDate datecreated, LocalDate dateUpdated) {
        this.name = name;
        this.codeValueCountry = codeValueCountry;
        this.dateCreated = datecreated;
        this.dateUpdated = dateUpdated;
    }

    public static Circuit instance(String name, CodeValue codeValueCountry, LocalDate datecreated, LocalDate dateUpdated, Integer numberLaps, RecordFastLap recordFastLap) {
        return new Circuit(name, codeValueCountry, datecreated, dateUpdated, numberLaps, recordFastLap);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CodeValue getCodeValueCountry() {
        return codeValueCountry;
    }

    public void setCodeValueCountry(CodeValue codeValueCountry) {
        this.codeValueCountry = codeValueCountry;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate datecreated) {
        this.dateCreated = datecreated;
    }

    public LocalDate getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(LocalDate dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public Integer getNumberLaps() {
        return numberLaps;
    }

    public void setNumberLaps(Integer numberLaps) {
        this.numberLaps = numberLaps;
    }

    public RecordFastLap getRecordFastLap() {
        return recordFastLap;
    }

    public void setRecordFastLap(RecordFastLap recordFastLap) {
        this.recordFastLap = recordFastLap;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    
    
}
