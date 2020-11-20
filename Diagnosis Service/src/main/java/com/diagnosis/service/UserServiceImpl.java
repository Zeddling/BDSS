package com.diagnosis.service;

import com.diagnosis.dao.UserRepository;
import com.diagnosis.model.UserFullDiagnosis;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserFullDiagnosis saveDiagnosis( UserFullDiagnosis userFullDiagnosis ) {
        return userRepository.save( userFullDiagnosis );
    }

    @Override
    public List<UserFullDiagnosis> fetchAllUsers(String id) {
        return userRepository.getAllById( id );
    }
}
