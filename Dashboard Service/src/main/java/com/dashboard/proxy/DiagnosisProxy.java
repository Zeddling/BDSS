package com.dashboard.proxy;

import com.dashboard.model.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.awt.*;
import java.util.List;

@FeignClient( name = "diagnosis-service", url="http://localhost:8250")
public interface DiagnosisProxy {

    @PostMapping("/api/diagnosis/create")
    void saveDiagnosis(@RequestBody PartialDiagnosis partialDiagnosis);

    @GetMapping("/api/diagnosis/patient/{id}")
    UserFullDiagnosis getDiagnosis( @PathVariable String patientNumber );

    @GetMapping("/api/diagnosis/patients")
    List<Patient> getPatients();

    @PostMapping("/api/diagnosis/predict")
    Diagnosis getPrediction(@RequestBody PredictionRequest predictionRequest);

    @GetMapping("/api/diagnosis/image/{patientNumber}")
    ImageModel getImage( @PathVariable String patientNumber );
}
