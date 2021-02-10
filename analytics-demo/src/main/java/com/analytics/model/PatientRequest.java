package com.analytics.model;

public class PatientRequest {

    private String patientName;
    private String diagnosisDate;

    public PatientRequest() {
    }

    public PatientRequest(String patientName, String diagnosisDate) {
        this.patientName = patientName;
        this.diagnosisDate = diagnosisDate;
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
}
