package com.diagnosis.controller;

import com.diagnosis.model.Diagnosis;
import com.diagnosis.service.DiagnosisService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
public class DiagnosisController {
    
    private DiagnosisService diagnosisService;

    @Autowired
    public DiagnosisController(DiagnosisService diagnosisService) {
        this.diagnosisService = diagnosisService;
    }

    @PostMapping("/diagnosis")  //  save diagnosis
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Diagnosis> addDiagnosis(@RequestBody Diagnosis diagnosis) {
        return diagnosisService.saveDiagnosis(diagnosis);
    }

    @GetMapping("/diagnosis/idNumber/{idNumber}")    //  find all by id number
    public Flux<Diagnosis> findAllByIdNumber(@PathVariable String idNumber) {
        log.info(idNumber);
        return diagnosisService.findAllByIdNumber(idNumber);
    }

    @GetMapping("/diagnosis/diagnosisId/{diagnosisId}")
    public Mono<ResponseEntity<Diagnosis>> findByDiagnosisId(@PathVariable String diagnosisId) {
        return diagnosisService.findByDiagnosisId(diagnosisId);
    }

    @DeleteMapping("/diagnosis/{diagnosisId}") //  delete mapping
    public Mono<ResponseEntity<Void>> deleteById(@PathVariable String diagnosisId) {
        return diagnosisService.deleteByDiagnosisId(diagnosisId);
    }
}
