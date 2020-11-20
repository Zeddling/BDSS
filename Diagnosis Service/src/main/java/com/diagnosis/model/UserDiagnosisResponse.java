package com.diagnosis.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDiagnosisResponse implements Serializable {

    private static final Long serialVersionUID = 2752745632623846732L;

    private String patientNumber;
    private MultipartFile diagnosedImage;

    public UserDiagnosisResponse(String patientNumber, MultipartFile diagnosedImage) {
        this.patientNumber = patientNumber;
        this.diagnosedImage = diagnosedImage;
    }

    public String getPatientNumber() {
        return patientNumber;
    }

    public void setPatientNumber(String patientNumber) {
        this.patientNumber = patientNumber;
    }

    public MultipartFile getDiagnosedImage() {
        return diagnosedImage;
    }

    public void setDiagnosedImage(MultipartFile diagnosedImage) {
        this.diagnosedImage = diagnosedImage;
    }
}
