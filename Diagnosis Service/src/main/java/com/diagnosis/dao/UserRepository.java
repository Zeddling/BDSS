package com.diagnosis.dao;

import com.diagnosis.model.UserFullDiagnosis;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<UserFullDiagnosis, String> {

    @Query("SELECT * FROM user WHERE patientNumber = ?")
    List<UserFullDiagnosis> getAllById( String id );

}
