package com.dashboard.model;

public class PartialDiagnosis {
    private String patientNumber;
    private String patientName;
    private String diagnosisDate;
    private String breast_side;
    private String image_view;
    private String comments;

    public PartialDiagnosis() {
    }

    public PartialDiagnosis(String patientNumber, String patientName, String diagnosisDate, String breast_side,
                            String image_view, String comments) {
        this.patientNumber = patientNumber;
        this.patientName = patientName;
        this.diagnosisDate = diagnosisDate;
        this.breast_side = breast_side;
        this.image_view = image_view;
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

    public String getDiagnosisDate() {
        return diagnosisDate;
    }

    public void setDiagnosisDate(String diagnosisDate) {
        this.diagnosisDate = diagnosisDate;
    }

    public String getBreast_side() {
        return breast_side;
    }

    public void setBreast_side(String breast_side) {
        this.breast_side = breast_side;
    }

    public String getImage_view() {
        return image_view;
    }

    public void setImage_view(String image_view) {
        this.image_view = image_view;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}

