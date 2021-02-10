package com.analytics.dao;

import com.analytics.model.Diagnosis;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AnalyticsRepository extends JpaRepository<Diagnosis, Long> {
    Diagnosis findByPatientName( String patientNumber );
    List<Diagnosis> findAllByPatientNumber( String patientNumber );
    Diagnosis findByPatientNumberAndDiagnosisDate( String patientNumber, String diagnosisDate );
}
