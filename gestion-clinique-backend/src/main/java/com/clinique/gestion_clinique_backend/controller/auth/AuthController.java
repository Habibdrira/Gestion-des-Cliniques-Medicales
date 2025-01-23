package com.clinique.gestion_clinique_backend.controller.auth;

import com.clinique.gestion_clinique_backend.enums.Role;
import com.clinique.gestion_clinique_backend.model.Patient;
import com.clinique.gestion_clinique_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public ModelAndView login(@RequestParam(value = "error", required = false) String error) {
        ModelAndView modelAndView = new ModelAndView("auth/login");
        if (error != null) {
            modelAndView.addObject("error", "Nom d'utilisateur ou mot de passe incorrect.");
        }
        return modelAndView;
    }

    @GetMapping("/register")
    public ModelAndView register(@RequestParam(value = "error", required = false) String error) {
        ModelAndView modelAndView = new ModelAndView("auth/register");
        if (error != null) {
            modelAndView.addObject("error", error);
        }
        return modelAndView;
    }

    @PostMapping("/register")
    public String register(@RequestParam String nom,
                           @RequestParam String prenom,
                           @RequestParam String email,
                           @RequestParam String password,
                           @RequestParam String confirmPassword) {

        if (!password.equals(confirmPassword)) {
            return "redirect:/auth/register?error=Passwords do not match";
        }

        if (userRepository.findByEmail(email).isPresent()) {
            return "redirect:/auth/register?error=Email already in use";
        }

        Patient patient = new Patient();
        patient.setNom(nom);
        patient.setPrenom(prenom);
        patient.setEmail(email);
        patient.setPassword(passwordEncoder.encode(password));
        patient.setRole(Role.PATIENT);

        userRepository.save(patient);

        return "redirect:/auth/login";
    }
}
