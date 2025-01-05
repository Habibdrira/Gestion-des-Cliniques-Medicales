package com.clinique.gestion_clinique_backend.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String showDashboard() {
        return "login"; // Nom du fichier HTML dans src/main/resources/templates
    }
}

