package com.clinique.gestion_clinique_backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {


    @GetMapping("/welcome")
    public String showaWelcomePage() {
        return "pages/welcome"; // Affiche pages/welcome.html
    }

}
