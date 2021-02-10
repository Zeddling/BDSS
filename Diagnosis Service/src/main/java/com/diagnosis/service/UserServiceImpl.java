package com.diagnosis.service;

import com.diagnosis.dao.UserRepository;
import com.diagnosis.model.Patient;
import com.diagnosis.model.UserFullDiagnosis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserFullDiagnosis saveDiagnosis( UserFullDiagnosis userFullDiagnosis ) {
        return userRepository.save( userFullDiagnosis );
    }

    @Override
    public List<Patient> fetchAllUsers() {
        List<UserFullDiagnosis> userFullDiagnosisList = (List<UserFullDiagnosis>) userRepository.findAll();
        List<Patient> patientList = null;
        int i = 0;
        for ( UserFullDiagnosis fullDiagnosis: userFullDiagnosisList ) {
            patientList.add( new Patient(i, fullDiagnosis.getPatientNumber(), fullDiagnosis.getPatientName(), fullDiagnosis.getDiagnosisDate()) );
            i++;
        }
        return patientList;
    }

    @Override
    public UserFullDiagnosis findByPatientNumber(String patientNumber) {
        Optional<UserFullDiagnosis> userFullDiagnosisOptional = userRepository.findByPatientNumber( patientNumber );
        return userFullDiagnosisOptional.orElseGet( UserFullDiagnosis::new );
    }

    @Override
    public void deleteDiagnosisByPatientNumber(String patientNumber) {
        userRepository.deleteByPatientNumber( patientNumber );
    }

}
