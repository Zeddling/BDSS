package com.dashboard.model;

import org.springframework.web.multipart.MultipartFile;

public class ImageUpload {

    private String patientNumber;
    private MultipartFile multipartFile;

    public ImageUpload() {
    }

    public ImageUpload(String patientNumber, MultipartFile multipartFile) {
        this.patientNumber = patientNumber;
        this.multipartFile = multipartFile;
    }

    public String getPatientNumber() {
        return patientNumber;
    }

    public void setPatientNumber(String patientNumber) {
        this.patientNumber = patientNumber;
    }

    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }
}