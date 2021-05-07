package com.diagnosis.service;

import com.diagnosis.model.Diagnosis;

import org.springframework.http.ResponseEntity;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DiagnosisService {
    Mono<Diagnosis> saveDiagnosis(Diagnosis diagnosis);
    Flux<Diagnosis> findAllByIdNumber(String idNumber);
    Mono<ResponseEntity<Diagnosis>> findByDiagnosisId(String diagnosisId);
    Mono<ResponseEntity<Void>> deleteByDiagnosisId(String diagnosisId);
}
