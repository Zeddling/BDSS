package com.dashboard.controller;

import com.dashboard.model.*;
import com.dashboard.proxy.DiagnosisProxy;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Controller
@RequestMapping("/api/dashboard/")
public class DashboardController {
    private final static Logger log = LoggerFactory.getLogger( DashboardController.class );

    @Autowired
    DiagnosisProxy diagnosisProxy;

    /*
    *   Serve pages to client
    */

    @ModelAttribute("partialDiagnosis")
    PartialDiagnosis partialDiagnosis(){
	return new PartialDiagnosis();
    }

    @ModelAttribute("imageUpload")
    ImageUpload imageUpload(){
	return new ImageUpload();
    }

    @GetMapping("new-diagnosis")
    public String dashboardNewDiagnosis(@AuthenticationPrincipal OidcUser user, Model model) {
         model.addAttribute("name", user.getAttribute("email"));
        return "index";
    }

    @GetMapping("view-diagnosis")
    public String dashboardViewDiagnosis( @AuthenticationPrincipal OidcUser user, Model model  ) {
        model.addAttribute( "name", user.getAttribute( "email" ) );
        List<Patient> patientList = diagnosisProxy.getPatients();
        model.addAttribute( "patients", patientList);
        return "diagnoses-list";
    }

    @RequestMapping(value="predict", method = RequestMethod.POST)
    public String predict(@AuthenticationPrincipal OidcUser user, Model model, @RequestParam("patientNumber") String patientNumber, @RequestParam("img_logo") MultipartFile file) {
        model.addAttribute( "name", user.getAttribute( "email" ) );
        log.info(file.getContentType());
	log.info(patientNumber);
        Diagnosis diagnosis = diagnosisProxy.getPrediction( new PredictionRequest( file ));
        model.addAttribute( "diagnosis", diagnosis );
        return "view-patient";
    }

    /* *
     * CRUD Operations
     * */
    @GetMapping("view-diagnosis/{patient-number}")
    public String dashboardViewPatientDiagnosis( @AuthenticationPrincipal OidcUser user, Model model, @PathVariable String patientNumber ) {
        model.addAttribute( "name", user.getAttribute( "email" ) );
        UserFullDiagnosis userFullDiagnosis = diagnosisProxy.getDiagnosis( patientNumber );
        model.addAttribute( "patient", userFullDiagnosis );
        return "view_patient";
    }

    @PostMapping("create-diagnosis")
    public String createDiagnosis(@AuthenticationPrincipal OidcUser oidcUser, Model model, @ModelAttribute("partialDiagnosis") PartialDiagnosis partialDiagnosis) {
        model.addAttribute("name", oidcUser.getAttribute("email"));
        diagnosisProxy.saveDiagnosis(partialDiagnosis);
        model.addAttribute("patient", partialDiagnosis.getPatientNumber());
	    return "upload";
    }

    @GetMapping("/image/{patientNumber}")
    public void showImage(@PathVariable String patientNumber, HttpServletResponse response) {
        response.setContentType( "image/png" );
        ImageModel imageModel = diagnosisProxy.getImage( patientNumber );
        InputStream inputStream = new ByteArrayInputStream(imageModel.getBytes());
        try {
            IOUtils.copy(inputStream, response.getOutputStream());
        } catch (IOException e) {
            log.error( e.getMessage() );
        }
    }

}
