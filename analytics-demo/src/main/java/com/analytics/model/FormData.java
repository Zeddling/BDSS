package com.analytics.model;

import org.springframework.web.multipart.MultipartFile;

public class FormData {
    private String patientName;
    private String patientNumber;
    private String image_view;
    private String breast_side;
    private String diagnosisDate;
    private MultipartFile mammogram;

    public FormData() {
    }

    public FormData(String patientName, String patientNumber, String image_view, String breast_side,
                    String diagnosisDate, MultipartFile mammogram) {
        this.patientName = patientName;
        this.patientNumber = patientNumber;
        this.image_view = image_view;
        this.breast_side = breast_side;
        this.diagnosisDate = diagnosisDate;
        this.mammogram = mammogram;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientNumber() {
        return patientNumber;
    }

    public void setPatientNumber(String patientNumber) {
        this.patientNumber = patientNumber;
    }

    public String getImage_view() {
        return image_view;
    }

    public void setImage_view(String image_view) {
        this.image_view = image_view;
    }

    public String getBreast_side() {
        return breast_side;
    }

    public void setBreast_side(String breast_side) {
        this.breast_side = breast_side;
    }

    public String getDiagnosisDate() {
        return diagnosisDate;
    }

    public void setDiagnosisDate(String diagnosisDate) {
        this.diagnosisDate = diagnosisDate;
    }

    public MultipartFile getMammogram() {
        return mammogram;
    }

    public void setMammogram(MultipartFile mammogram) {
        this.mammogram = mammogram;
    }
}
