package com.diagnosis.service;

import com.diagnosis.model.Patient;
import com.diagnosis.model.User;
import com.diagnosis.model.UserFullDiagnosis;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    UserFullDiagnosis saveDiagnosis(UserFullDiagnosis userFullDiagnosis);
    List<Patient> fetchAllUsers();
    UserFullDiagnosis findByPatientNumber( String patientNumber );
    void deleteDiagnosisByPatientNumber( String patientNumber );
}
