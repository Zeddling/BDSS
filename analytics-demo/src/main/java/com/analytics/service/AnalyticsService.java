package com.analytics.service;

import com.analytics.model.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AnalyticsService {

    void save( Diagnosis diagnosis );
    void save( ImageModel imageModel );
    PatientResponse findByPatientNumberAndDiagnosisDate(PatientRequest patientRequest);
    List<PatientResponse> findByAllByPatientNumber( String patientNumber );
    List<PatientResponse> findAllPatients();
    ImageModel getImageModel( String name );
    FormData getJson(String formData);
}
