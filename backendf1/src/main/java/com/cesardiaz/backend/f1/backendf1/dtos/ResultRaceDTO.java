package com.cesardiaz.backend.f1.backendf1.dtos;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ResultRaceDTO {

    private Long resultRaceId;
    private Double points;
    private Boolean dnf;
    private Boolean dns;
    private Boolean dnq;
    private RecordFastlapDTO recordFastlap;
    private String dateCreated;
    private String dateUpdated;
    private DriverDTO driver;
    private ScheduleGranPrixDTO ScheduleGranPrix;

    public ResultRaceDTO(Long resultRaceId, Double points, Boolean dnf, Boolean dns, Boolean dnq,
            RecordFastlapDTO recordFastlap, String dateCreated, String dateUpdated, DriverDTO driver,
            ScheduleGranPrixDTO scheduleGranPrix) {
        this.resultRaceId = resultRaceId;
        this.points = points;
        this.dnf = dnf;
        this.dns = dns;
        this.dnq = dnq;
        this.recordFastlap = recordFastlap;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
        this.driver = driver;
        ScheduleGranPrix = scheduleGranPrix;
    }

    public Long getResultRaceId() {
        return resultRaceId;
    }

    public void setResultRaceId(Long resultRaceId) {
        this.resultRaceId = resultRaceId;
    }

    public Double getPoints() {
        return points;
    }

    public void setPoints(Double points) {
        this.points = points;
    }

    public Boolean getDnf() {
        return dnf;
    }

    public void setDnf(Boolean dnf) {
        this.dnf = dnf;
    }

    public Boolean getDns() {
        return dns;
    }

    public void setDns(Boolean dns) {
        this.dns = dns;
    }

    public Boolean getDnq() {
        return dnq;
    }

    public void setDnq(Boolean dnq) {
        this.dnq = dnq;
    }

    public RecordFastlapDTO getRecordFastlap() {
        return recordFastlap;
    }

    public void setRecordFastlap(RecordFastlapDTO recordFastlap) {
        this.recordFastlap = recordFastlap;
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

    public DriverDTO getDriver() {
        return driver;
    }

    public void setDriver(DriverDTO driver) {
        this.driver = driver;
    }

    public ScheduleGranPrixDTO getScheduleGranPrix() {
        return ScheduleGranPrix;
    }

    public void setScheduleGranPrix(ScheduleGranPrixDTO scheduleGranPrix) {
        ScheduleGranPrix = scheduleGranPrix;
    }

    

}
