package com.analytics.controller;

import com.analytics.dao.PreprocessorProxy;
import com.analytics.model.*;
import com.analytics.service.AnalyticsService;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Controller
@RequestMapping("/api/")
public class DemoController {
    private static final Logger log = LoggerFactory.getLogger( DemoController.class );

    @Autowired
    PreprocessorProxy preprocessorProxy;

    @Autowired
    AnalyticsService analyticsService;

    @ModelAttribute("formData")
    public FormData formData() {
        return new FormData();
    }

    @ModelAttribute("predictionRequest")
    public PredictionRequest predictionRequest(){
        return new PredictionRequest();
    }

    /* *
     * Views
     */
    @GetMapping("index")
    public String index(Model model) {
        List<PatientResponse> patientResponseList = analyticsService.findAllPatients();
        model.addAttribute( "patients", patientResponseList );
        return "index";
    }

    @GetMapping("test")
    public String testIndex(Model model){
	    Prediction pred = new Prediction();
	    model.addAttribute("pred", pred);
        return "test-index";
    }

    @GetMapping("create")
    public String create() {
        return "create-diagnosis";
    }

    @PostMapping("/predict-test")
    public String predictionTest( @ModelAttribute("predictionRequest") PredictionRequest predictionRequest, Model model ) {
        Prediction prediction = preprocessorProxy.getPreprocessedImage( predictionRequest );
        model.addAttribute("pred", prediction);
        return "test-index";
    }

    /* *
     * API Functions for later use of course
     * */

    @GetMapping("patient")
    public PatientResponse getPatient( @RequestBody PatientRequest patientRequest ) {
        return analyticsService.findByPatientNumberAndDiagnosisDate( patientRequest );
    }

    @GetMapping("patients")
    public List<PatientResponse> getAllPatients() {
        return analyticsService.findAllPatients();
    }

    @GetMapping("patients/{patientNumber}")
    public List<PatientResponse> getAllPatientsByPatientNumber( @PathVariable String patientNumber ) {
        return analyticsService.findByAllByPatientNumber(patientNumber);
    }

    @GetMapping("mammogram/{name}")
    public void showMammogram(@PathVariable String name, HttpServletResponse response) {
        response.setContentType("image/png");
        ImageModel imageModel = analyticsService.getImageModel( name );
        InputStream inputStream = new ByteArrayInputStream( imageModel.getPic() );
        try {
            IOUtils.copy( inputStream, response.getOutputStream() );
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

}
