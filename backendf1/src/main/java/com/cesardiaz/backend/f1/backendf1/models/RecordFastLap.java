package com.cesardiaz.backend.f1.backendf1.models;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@NamedQuery(name = "RecordFastLap.findAll", query = "SELECT rf FROM RecordFastLap rf")
@Table(name = "record_fastlap")
public class RecordFastLap extends AbstractPersistableCustom<Long>{
    
    @Column(name= "number_driver", columnDefinition="varchar(2)")
    private String recordFastLap;
    
    // @ManyToOne
    // @JoinColumn(name = "result_race_id", nullable = false)
    // private ResultRace resultRace;

    @ManyToOne
    @JoinColumn(name = "circuit_id", nullable = false)
    private Circuit circuit;

    @ManyToOne
    @JoinColumn(name = "code_value_seasson_id", nullable = false)
    private CodeValue codeValueSeasson;
    
    @Column(name= "status")
    private Integer status;

    @Column(name= "date_created")
    private LocalDate datecreated;
    
    @Column(name= "date_updated")
    private LocalDate dateUpdated;

    private RecordFastLap(String recordFastLap, 
            Circuit circuit, CodeValue codeValueSeasson, Integer status, LocalDate datecreated, LocalDate dateUpdated) {
        this.recordFastLap = recordFastLap;
        this.circuit = circuit;
        this.codeValueSeasson = codeValueSeasson;
        this.status = status;
        this.datecreated = datecreated;
        this.dateUpdated = dateUpdated;
    }

    public static RecordFastLap instance(String recordFastLap,
    Circuit circuit, CodeValue codeValueSeasson, Integer status, LocalDate datecreated, LocalDate dateUpdated){
        return new RecordFastLap(recordFastLap, circuit, codeValueSeasson, status, datecreated, dateUpdated);
    }

    public String getRecordFastLap() {
        return recordFastLap;
    }

    public void setRecordFastLap(String recordFastLap) {
        this.recordFastLap = recordFastLap;
    }
    public Circuit getCircuit() {
        return circuit;
    }

    public void setCircuit(Circuit circuit) {
        this.circuit = circuit;
    }

    public CodeValue getCodeValueSeasson() {
        return codeValueSeasson;
    }

    public void setCodeValueSesson(CodeValue codeValueSeasson) {
        this.codeValueSeasson = codeValueSeasson;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDate getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(LocalDate datecreated) {
        this.datecreated = datecreated;
    }

    public LocalDate getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(LocalDate dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    
    
}
