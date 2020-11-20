package com.diagnosis.service;

import com.diagnosis.model.User;
import com.diagnosis.model.UserFullDiagnosis;

import java.util.List;

public interface UserService {

    UserFullDiagnosis saveDiagnosis(UserFullDiagnosis userFullDiagnosis);

    List<UserFullDiagnosis> fetchAllUsers(String id );

}
