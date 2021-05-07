package com.diagnosis.service;

import java.time.LocalDate;
import java.util.UUID;

import com.diagnosis.dao.DiagnosisRepository;
import com.diagnosis.model.Diagnosis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DiagnosisServiceImpl implements DiagnosisService {

    private DiagnosisRepository diagnosisRepository;

    @Autowired
    public DiagnosisServiceImpl(DiagnosisRepository diagnosisRepository) {
        this.diagnosisRepository = diagnosisRepository;
    }

    @Override   //  Save diagnosis
    public Mono<Diagnosis> saveDiagnosis(Diagnosis diagnosis) {
        if (diagnosis.getDiagnosisId() == null){         //  to enable testing the module onl
            diagnosis.setDiagnosisId(UUID.randomUUID());
            diagnosis.setDiagnosisDate(LocalDate.now()); 
        }
        else {  // set diagnosis date only if uid is present
            diagnosis.setDiagnosisDate(LocalDate.now());            
        }
        return diagnosisRepository.save(diagnosis);
    }

    @Override   //  Find all diagnoses by id number
    public Flux<Diagnosis> findAllByIdNumber(String idNumber) {
        return diagnosisRepository.findAllByIdNumber(idNumber);
    }

    @Override
    public Mono<ResponseEntity<Diagnosis>> findByDiagnosisId(String diagnosisId) {
        UUID id = UUID.fromString(diagnosisId);
        return diagnosisRepository.findByDiagnosisId(id)
                .map(diagnosis -> new ResponseEntity<Diagnosis>(diagnosis, HttpStatus.OK))   
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override   //  Delete diagnosis by id number
    public Mono<ResponseEntity<Void>> deleteByDiagnosisId(String diagnosisId) {
        UUID id = UUID.fromString(diagnosisId);
        return diagnosisRepository.findByDiagnosisId(id)
                .flatMap(diagnosis -> diagnosisRepository.delete(diagnosis)
                    .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
    }
}
