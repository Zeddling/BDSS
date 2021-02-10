package com.diagnosis.model;

public class Diagnosis {
    private String patientNumber;
    private String patientName;
    private String diagnosisDate;
    private String breast_side;
    private String image_view;
    private String pathology;
    private String comments;
    private byte[] image;

    public Diagnosis() {
    }

    public Diagnosis(String patientNumber, String patientName, String diagnosisDate, String breast_side, String image_view,
                     String pathology, String comments, byte[] image) {
        this.patientNumber = patientNumber;
        this.patientName = patientName;
        this.diagnosisDate = diagnosisDate;
        this.breast_side = breast_side;
        this.image_view = image_view;
        this.pathology = pathology;
        this.comments = comments;
        this.image = image;
    }

    public String getPatientNumber() {
        return patientNumber;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getDiagnosisDate() {
        return diagnosisDate;
    }

    public String getBreast_side() {
        return breast_side;
    }

    public String getImage_view() {
        return image_view;
    }

    public String getPathology() {
        return pathology;
    }

    public String getComments() {
        return comments;
    }

    public byte[] getImage() {
        return image;
    }
}