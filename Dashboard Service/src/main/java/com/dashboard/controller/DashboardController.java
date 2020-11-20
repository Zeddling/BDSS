package com.dashboard.controller;

import com.dashboard.model.DiagnosisRequest;
import com.dashboard.model.User;
import com.dashboard.model.UserFullDiagnosis;
import com.dashboard.proxy.DiagnosisProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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

    @GetMapping("new-diagnosis")
    public String dashboardNewDiagnosis(@AuthenticationPrincipal OidcUser user, Model model) {
         model.addAttribute("name", user.getAttribute("email"));


        return "new_diagnosis";
    }

    @GetMapping("view-diagnosis")
    public String dashboardViewDiagnosis( @AuthenticationPrincipal OidcUser user, Model model  ) {

        model.addAttribute( "name", user.getAttribute( "email" ) );
        return "view_diagnosis";
    }

    @GetMapping("support")
    public String dashboardSupport( @AuthenticationPrincipal OidcUser user, Model model  ) {
        model.addAttribute( "name", user.getAttribute( "email" ) );
        return "support";
    }

    //  Consume diagnosis service
    @PostMapping("create-diagnosis")
    public UserFullDiagnosis createDiagnosis( @ModelAttribute User user ) {
        return diagnosisProxy.saveDiagnosis( user );
    }



}
