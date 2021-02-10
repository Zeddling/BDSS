package com.dashboard.model;

public class Diagnosis {
    private String patientNumber;
    private String patientName;
    private String diagnosisDate;
    private String image_view;
    private String pathology;
    private String comments;
    private byte[] image;

    public Diagnosis() {
    }

    public Diagnosis(String patientNumber, String patientName, String diagnosisDate, String image_view,
                     String pathology, String comments, byte[] image) {
        this.patientNumber = patientNumber;
        this.patientName = patientName;
        this.diagnosisDate = diagnosisDate;
        this.image_view = image_view;
        this.pathology = pathology;
        this.comments = comments;
        this.image = image;
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

    public String getDiagnosisDate() {
        return diagnosisDate;
    }

    public void setDiagnosisDate(String diagnosisDate) {
        this.diagnosisDate = diagnosisDate;
    }

    public String getImage_view() {
        return image_view;
    }

    public void setImage_view(String image_view) {
        this.image_view = image_view;
    }

    public String getPathology() {
        return pathology;
    }

    public void setPathology(String pathology) {
        this.pathology = pathology;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}