package com.clinique.gestion_clinique_backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/admin/dashboard")
    public String adminDashboard() {
        return "admin/dashboard";  // Vue du tableau de bord admin
    }

    @GetMapping("/medecin/dashboard")
    public String medecinDashboard() {
        return "medecin/dashboard";  // Vue du tableau de bord médecin
    }

    @GetMapping("/patient/dashboard")
    public String patientDashboard() {
        return "patient/dashboard";  // Vue du tableau de bord patient
    }
}
