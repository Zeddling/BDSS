package com.user.service;

import com.user.model.User;

import org.springframework.http.ResponseEntity;

import reactor.core.publisher.Mono;

public interface UserService {
    Mono<User> addUser(User user);          //  Register user
    Mono<ResponseEntity<Void>> deleteUser(String username); //  Delete user
    Mono<ResponseEntity<User>> findByUsername(String username);    //  get user by email address

}
