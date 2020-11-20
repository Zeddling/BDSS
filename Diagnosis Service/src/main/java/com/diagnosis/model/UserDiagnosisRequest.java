package com.diagnosis.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

@JsonIgnoreProperties( ignoreUnknown = true )
public class UserDiagnosisRequest implements Serializable {

    private static final Long serialVersionUID = 2852645326549324327L;

    private String patientNumber;

    private MultipartFile classifiedImage;

    public UserDiagnosisRequest(String patientNumber, MultipartFile classifiedImage) {
        this.patientNumber = patientNumber;
        this.classifiedImage = classifiedImage;
    }

    public String getPatientNumber() {
        return patientNumber;
    }

    public void setPatientNumber(String patientNumber) {
        this.patientNumber = patientNumber;
    }

    public MultipartFile getClassifiedImage() {
        return classifiedImage;
    }

    public void setClassifiedImage(MultipartFile classifiedImage) {
        this.classifiedImage = classifiedImage;
    }
}
