package com.clinique.gestion_clinique_backend.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping
    public ModelAndView loginPage(@RequestParam(value = "error", required = false) String error) {
        ModelAndView modelAndView = new ModelAndView("login"); // vue de la page de connexion
        if (error != null) {
            modelAndView.addObject("error", "Nom d'utilisateur ou mot de passe incorrect.");
        }
        return modelAndView;
    }

    @GetMapping("/login-success")
    public String loginSuccess() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String role = authentication.getAuthorities().toString();
        if (role.contains("ROLE_ADMIN")) {
            return "redirect:/admin/dashboard"; // Page pour l'admin
        } else if (role.contains("ROLE_MEDECIN")) {
            return "redirect:/medecin/dashboard"; // Page pour le médecin
        } else if (role.contains("ROLE_PATIENT")) {
            return "redirect:/patient/dashboard"; // Page pour le patient
        }
        return "redirect:/"; // Page d'accueil par défaut
    }
}
