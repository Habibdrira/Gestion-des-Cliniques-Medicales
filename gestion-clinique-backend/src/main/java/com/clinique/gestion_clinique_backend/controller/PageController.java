package com.clinique.gestion_clinique_backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String redirectToWelcome() {
        return "redirect:/welcome"; // Redirige automatiquement vers /welcome
    }

    @GetMapping("/welcome")
    public String showWelcomePage() {
        return "pages/welcome"; // Affiche pages/welcome.html
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // Affiche login.html dans templates/
    }

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register"; // Affiche register.html dans templates/
    }
}
