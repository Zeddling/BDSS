package com.analytics.model;

public class PatientResponse {
    private long id;
    private String patientName;
    private String patientNumber;
    private String image_view;
    private String breast_side;
    private String diagnosisDate;
    private String prediction;
    private String confidence_level;
    private ImageModel mammogram;

    public PatientResponse() {
    }

    public PatientResponse(long id, String patientName, String patientNumber, String image_view, String breast_side,
                           String diagnosisDate, String prediction, String confidence_level) {
        this.id = id;
        this.patientName = patientName;
        this.patientNumber = patientNumber;
        this.image_view = image_view;
        this.breast_side = breast_side;
        this.diagnosisDate = diagnosisDate;
        this.prediction = prediction;
        this.confidence_level = confidence_level;
    }

    public PatientResponse(String patientName, String patientNumber, String image_view, String breast_side, String diagnosisDate,
                           String prediction, String confidence_level, ImageModel mammogram) {
        this.patientName = patientName;
        this.patientNumber = patientNumber;
        this.image_view = image_view;
        this.breast_side = breast_side;
        this.diagnosisDate = diagnosisDate;
        this.prediction = prediction;
        this.confidence_level = confidence_level;
        this.mammogram = mammogram;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getPrediction() {
        return prediction;
    }

    public void setPrediction(String prediction) {
        this.prediction = prediction;
    }

    public String getConfidence_level() {
        return confidence_level;
    }

    public void setConfidence_level(String confidence_level) {
        this.confidence_level = confidence_level;
    }

    public ImageModel getMammogram() {
        return mammogram;
    }

    public void setMammogram(ImageModel mammogram) {
        this.mammogram = mammogram;
    }
}
