package com.dashboard.controller;

import com.dashboard.dao.DashboardRepo;
import com.dashboard.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.Optional;

@Controller
@RequestMapping("/dashboard/")
public class DashboardController {
    private final static Logger log = LoggerFactory.getLogger( DashboardController.class );

    @Autowired
    DashboardRepo repo;

    @GetMapping("index")
    public String dashboardIndex(@AuthenticationPrincipal OidcUser user, Model model) {
         model.addAttribute("name", user.getAttribute("email"));
        return "dashboard";
    }

}
