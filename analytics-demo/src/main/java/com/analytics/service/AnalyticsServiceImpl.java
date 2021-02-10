package com.analytics.service;

import com.analytics.dao.AnalyticsRepository;
import com.analytics.dao.ImageModelRepository;
import com.analytics.model.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class AnalyticsServiceImpl implements AnalyticsService {

    private static final Logger log = LoggerFactory.getLogger(AnalyticsServiceImpl.class);

    @Autowired
    AnalyticsRepository analyticsRepository;

    @Autowired
    ImageModelRepository imageModelRepository;

    @Override
    public void save(Diagnosis diagnosis) {
        analyticsRepository.save( diagnosis );
    }

    @Override
    public void save(ImageModel imageModel) {
        imageModelRepository.save( imageModel );
    }

    @Override
    public PatientResponse findByPatientNumberAndDiagnosisDate(PatientRequest patientRequest) {
        Diagnosis diagnosis = analyticsRepository.findByPatientNumberAndDiagnosisDate(patientRequest.getPatientName(), patientRequest.getDiagnosisDate() );
        Optional<ImageModel> imageModelOptional = imageModelRepository.findByName( diagnosis.getFilename() );
        ImageModel imageModel = imageModelOptional.orElseGet( ImageModel::new );
        return new PatientResponse(
                diagnosis.getPatientName(), diagnosis.getPatientNumber(), diagnosis.getImage_view(),
                diagnosis.getBreast_side(), diagnosis.getDiagnosisDate(), diagnosis.getPrediction(),
                diagnosis.getConfidence_level(), imageModel
        );
    }

    @Override
    public List<PatientResponse> findByAllByPatientNumber(String patientNumber) {
        List<PatientResponse> patientResponseList = null;
        List<Diagnosis> diagnosisList = analyticsRepository.findAllByPatientNumber( patientNumber );

        for ( Diagnosis diagnosis : diagnosisList ) {
            patientResponseList.add( new PatientResponse(
                    diagnosis.getId(), diagnosis.getPatientName(), diagnosis.getPatientNumber(), diagnosis.getImage_view(), diagnosis.getBreast_side(),
                    diagnosis.getDiagnosisDate(), diagnosis.getPrediction(), diagnosis.getConfidence_level()
            ) );
        }
        return patientResponseList;
    }

    @Override
    public List<PatientResponse> findAllPatients() {
        List<Diagnosis> diagnosisList = analyticsRepository.findAll();
        List<PatientResponse> patientResponseList = null;

        for ( Diagnosis diagnosis : diagnosisList ) {
            patientResponseList.add( new PatientResponse(
                    diagnosis.getId(), diagnosis.getPatientName(), diagnosis.getPatientNumber(), diagnosis.getImage_view(), diagnosis.getBreast_side(),
                    diagnosis.getDiagnosisDate(), diagnosis.getPrediction(), diagnosis.getConfidence_level()
            ) );
        }
        return patientResponseList;
    }

    @Override
    public ImageModel getImageModel(String name) {
        Optional<ImageModel> imageModelOptional = imageModelRepository.findByName(name);
        return imageModelOptional.orElseGet(ImageModel::new);
    }

    @Override
    public FormData getJson(String formData) {
        FormData data = new FormData();
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            data = objectMapper.readValue(formData, FormData.class);
        }   catch (IOException e) {
            log.error(e.getMessage());
        }
        return data;
    }


}
