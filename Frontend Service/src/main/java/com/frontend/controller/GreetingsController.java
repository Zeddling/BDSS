package com.frontend.controller;

import org.keycloak.adapters.springsecurity.account.SimpleKeycloakAccount;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;

import javax.validation.constraints.NotNull;

@Validated
@Controller
public class GreetingsController {

    @GetMapping("/greetings")
    public String greeting(@NotNull Model model, @NotNull Authentication authentication ) {
        String email = ( ( SimpleKeycloakAccount ) authentication.getDetails() )
                .getKeycloakSecurityContext()
                .getToken()
                .getEmail();
        model.addAttribute( "name", email );
        return "greetings";
    }

}
