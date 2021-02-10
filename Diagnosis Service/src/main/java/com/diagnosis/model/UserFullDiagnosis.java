package com.diagnosis.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class UserFullDiagnosis implements Serializable {

    private static final Long serialVersionUID = 2874875646387463249L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String patientNumber;
    private String patientName;
    private String diagnosisDate;
    private String filename;
    private String breast_side;
    private String image_view;
    private String pathology;
    private String comments;

    public UserFullDiagnosis() {
    }

    public UserFullDiagnosis(String patientNumber, String patientName, String diagnosisDate, String filename, String breast_side, String image_view, String pathology, String comments) {
        this.patientNumber = patientNumber;
        this.patientName = patientName;
        this.diagnosisDate = diagnosisDate;
        this.filename = filename;
	    this.breast_side = breast_side;
        this.image_view = image_view;
        this.pathology = pathology;
        this.comments = comments;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getPathology() {
        return pathology;
    }

    public void setPathology(String pathology) {
        this.pathology = pathology;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
