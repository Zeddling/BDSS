package com.user.service;

import java.time.LocalDate;
import java.util.UUID;

import com.user.dao.UserRepository;
import com.user.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

//  Interface class for user database interactions
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Mono<User> addUser(User user) {
        user.setId(UUID.randomUUID());      //  Set user UUID
        user.setLocalDate(LocalDate.now()); //  Set local date of creation
        log.info(user.toString());
        return userRepository.save(user);
    }

    @Override
    public Mono<ResponseEntity<User>> findByUsername(String username) {
        return userRepository.findByUsername(username)
                .map(user -> new ResponseEntity<User>(user, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<User>(HttpStatus.NOT_FOUND));
    }

    @Override
    public Mono<ResponseEntity<Void>> deleteUser(String username) {
        return userRepository.findByUsername(username)
                .flatMap(user -> userRepository.delete(user)
                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
    }


}
