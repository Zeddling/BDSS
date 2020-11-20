package com.dashboard.model;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.time.LocalDateTime;

//  Diagnosis request
public class DiagnosisRequest implements Serializable {

    private static final Long serialVersionUID = 1285626239652963290L;

    private String patientNumber;
    private String patientName;
    private LocalDateTime diagnosisDate;
    private Byte[] image;
    private String comments;

    public DiagnosisRequest(String patientNumber, String patientName,
                            LocalDateTime diagnosisDate, Byte[] image, String comments) {
        this.patientNumber = patientNumber;
        this.patientName = patientName;
        this.diagnosisDate = diagnosisDate;
        this.image = image;
        this.comments = comments;
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

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
