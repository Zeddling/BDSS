package com.diagnosis.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class UserFullDiagnosis implements Serializable {

    private static final Long serialVersionUID = 2874875646387463249L;

    @Id
    private String patientNumber;

    private String patientName;
    private LocalDateTime diagnosisDate;

    @Lob
    private byte[] mammogramData;

    private String comments;

    @Lob
    private byte[] diagnosedMammogramData;

    public UserFullDiagnosis() {
    }

    public UserFullDiagnosis(String patientNumber, String patientName, LocalDateTime diagnosisDate,
                             byte[] mammogramData, String comments, byte[] diagnosedMammogramData) {
        this.patientNumber = patientNumber;
        this.patientName = patientName;
        this.diagnosisDate = diagnosisDate;
        this.mammogramData = mammogramData;
        this.comments = comments;
        this.diagnosedMammogramData = diagnosedMammogramData;
    }

    public String getPatientNumber() {
        return patientNumber;
    }

    public void setPatientNumber(String patientNumber) {
        this.patientNumber = patientNumber;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public LocalDateTime getDiagnosisDate() {
        return diagnosisDate;
    }

    public void setDiagnosisDate(LocalDateTime diagnosisDate) {
        this.diagnosisDate = diagnosisDate;
    }

    public byte[] getMammogramData() {
        return mammogramData;
    }

    public void setMammogramData(byte[] mammogramData) {
        this.mammogramData = mammogramData;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public byte[] getDiagnosedMammogramData() {
        return diagnosedMammogramData;
    }

    public void setDiagnosedMammogramData(byte[] diagnosedMammogramData) {
        this.diagnosedMammogramData = diagnosedMammogramData;
    }
}
