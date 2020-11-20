package com.dashboard.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements Serializable {

    private static final Long serialVersionUID = 7290564756329239466L;

    private String patientNumber;
    private String patientName;
    private LocalDateTime diagnosisDate;
    private MultipartFile image;    //  Mammogram image
    private String comments;

    public User(String patientNumber, String patientName, LocalDateTime diagnosisDate,
                MultipartFile image, String comments) {
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

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
