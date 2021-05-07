package com.user.dao;

import java.util.UUID;

import com.user.model.User;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveMongoRepository<User, UUID>{
    Mono<User> findByUsername(String username);
}
