package com.diagnosis.controller;

import com.diagnosis.dao.AnalyticsProxy;
import com.diagnosis.dao.UserRepository;
import com.diagnosis.model.User;
import com.diagnosis.model.UserDiagnosisRequest;
import com.diagnosis.model.UserDiagnosisResponse;
import com.diagnosis.model.UserFullDiagnosis;
import com.diagnosis.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/diagnosis/")
public class DiagnosisController {

    private static final Logger log = LoggerFactory.getLogger( DiagnosisController.class );

    @Autowired
    private UserService userService;

    @Autowired
    private AnalyticsProxy analyticsProxy;

    @PostMapping("create")
    public UserFullDiagnosis saveDiagnosis( @RequestBody User user ) {
        //  Send mammogram to analytics engine
        UserDiagnosisResponse userDiagnosisResponse = analyticsProxy.getDiagnosis(
                new UserDiagnosisRequest( user.getPatientNumber(), user.getImage() )
        );

        //  Convert mammogram to bytes then save
        try {
            //`Save data to database
            return userService.saveDiagnosis( new UserFullDiagnosis(
                    user.getPatientNumber(), user.getPatientName(), user.getDiagnosisDate(), user.getImage().getBytes(),
                    user.getComments(), userDiagnosisResponse.getDiagnosedImage().getBytes()
            ));

        } catch (IOException e) {
            log.error( e.getMessage() );
            return new UserFullDiagnosis();
        }
    }

    @GetMapping("fetch-diagnosis-by-id/{id}")
    public List<UserFullDiagnosis> fetchAllDiagnosisById(@RequestParam("id") String patientNumber ) {
        return userService.fetchAllUsers( patientNumber );
    }

}
