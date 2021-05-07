package com.user.controller;

import com.user.model.User;
import com.user.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/user/{username}", produces = {MediaType.APPLICATION_JSON_VALUE}) //  get user by email 
    public Mono<ResponseEntity<User>> findUserByUsername(@PathVariable(required = true) String username) {
        log.info(username);
        return userService.findByUsername(username);
    }

    @PostMapping("/user")   //  controller to register user
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<User> registerUser(@RequestBody User user) {
        log.info("Saving user ", user.getUsername());
        return userService.addUser(user);
    }

    @DeleteMapping("/user/{username}")
    public Mono<ResponseEntity<Void>> deleteCar(@PathVariable String username) {
        return userService.deleteUser(username);
    }

}
