package com.diagnosis.controller;

import com.diagnosis.dao.ImageRepository;
import com.diagnosis.dao.PredictorProxy;
import com.diagnosis.model.*;
import com.diagnosis.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/diagnosis/")
public class DiagnosisController {

    private static final Logger log = LoggerFactory.getLogger( DiagnosisController.class );

    @Autowired
    private UserService userService;

    @Autowired
    ImageRepository imageRepository;

    @Autowired
    PredictorProxy predictorProxy;

    @PostMapping("predict")
    public Diagnosis getPrediction( @RequestBody ImageUpload imageUpload ) {
        Prediction prediction =predictorProxy.getPreprocessedImage( new PredictionRequest(imageUpload.getMultipartFile() ) );
        UserFullDiagnosis userFullDiagnosis = userService.findByPatientNumber( imageUpload.getPatientNumber() );
        userService.deleteDiagnosisByPatientNumber(imageUpload.getPatientNumber() );
        MultipartFile file = imageUpload.getMultipartFile();
        byte[] bytes = null;
        try {
            imageRepository.save( new ImageModel(file.getName(), file.getContentType(), file.getBytes()) );
            bytes = file.getBytes();
        } catch (IOException e) {
            log.error( e.getMessage() );
        }
        userFullDiagnosis.setPathology(prediction.getClass_name());
        userFullDiagnosis.setFilename(file.getName());
        userService.saveDiagnosis(userFullDiagnosis);
        return new Diagnosis(
                userFullDiagnosis.getPatientNumber(), userFullDiagnosis.getPatientName(),
                userFullDiagnosis.getDiagnosisDate(), userFullDiagnosis.getBreast_side(), userFullDiagnosis.getImage_view(), userFullDiagnosis.getPathology(),
                userFullDiagnosis.getComments(), bytes);
    }

    @PostMapping("create")
    public void create( @RequestBody PartialDiagnosis partialDiagnosis ) {
        byte[] bytes = null;
        userService.saveDiagnosis( new UserFullDiagnosis(
            partialDiagnosis.getPatientNumber(), partialDiagnosis.getPatientName(), partialDiagnosis.getDiagnosisDate(),
            partialDiagnosis.getBreast_side(), null, partialDiagnosis.getImage_view(), null, partialDiagnosis.getComments()
        ));
    }

    @GetMapping("patients")
    public List<Patient> getAllPatients() {
        return userService.fetchAllUsers();
    }

    @GetMapping("patient/{id}")
    public UserFullDiagnosis getDiagnosis( @PathVariable String patientNumber ) {
        return userService.findByPatientNumber( patientNumber );
    }

    @GetMapping("image/{patientNumber}")
    public ImageModel getImage( @PathVariable String patientNumber ) {
        UserFullDiagnosis userFullDiagnosis = userService.findByPatientNumber( patientNumber );
        Optional<ImageModel> imageModelOptional = imageRepository.findById(patientNumber);
        return imageModelOptional.orElseGet( ImageModel::new );
    }

}
