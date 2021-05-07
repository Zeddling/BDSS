package com.diagnosis.dao;

import java.util.UUID;

import com.diagnosis.model.Diagnosis;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DiagnosisRepository extends ReactiveMongoRepository<Diagnosis, UUID> {
    Flux<Diagnosis> findAllByIdNumber(String idNumber);
    Mono<Diagnosis> findByIdNumber(String idNumber);
    Mono<Diagnosis> findByDiagnosisId(UUID diagnosisId);
}
