package com.dashboard.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserFullDiagnosis implements Serializable {

    private static final Long serialVersionUID = 2874875646387463249L;

    private String patientNumber;
    private String patientName;
    private LocalDateTime diagnosisDate;
    private byte[] image;    //  Mammogram image
    private String comments;
    private byte[] diagnosedImage;
    private String status;

    public UserFullDiagnosis() {
    }

    public UserFullDiagnosis(String patientNumber, String patientName, LocalDateTime diagnosisDate,
                             byte[] image, String comments, byte[] diagnosedImage, String status) {
        this.patientNumber = patientNumber;
        this.patientName = patientName;
        this.diagnosisDate = diagnosisDate;
        this.image = image;
        this.comments = comments;
        this.diagnosedImage = diagnosedImage;
        this.status = status;
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public byte[] getDiagnosedImage() {
        return diagnosedImage;
    }

    public void setDiagnosedImage(byte[] diagnosedImage) {
        this.diagnosedImage = diagnosedImage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
