package com.diagnosis.dao;

import com.diagnosis.model.UserFullDiagnosis;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<UserFullDiagnosis, Long> {

    List<UserFullDiagnosis> findAllByPatientNumber( String id );
    Optional<UserFullDiagnosis> findByPatientNumber( String patientNumber );
    void deleteByPatientNumber( String patientNumber );
}
