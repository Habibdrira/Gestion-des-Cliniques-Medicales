package com.clinique.gestion_clinique_backend.controller.auth;

import com.clinique.gestion_clinique_backend.model.User;
import com.clinique.gestion_clinique_backend.enums.Role;
import com.clinique.gestion_clinique_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    // Page de connexion
    @GetMapping("/login")
    public String loginPage() {
        return "login1";
    }

    // Page d'inscription
    @GetMapping("/register")
    public String registerPage() {
        return "register2";
    }

    // Enregistrement d'un nouvel utilisateur avec un rôle choisi
    @PostMapping("/register")
    public String register(@RequestParam String nom,
                           @RequestParam String prenom,
                           @RequestParam String email,
                           @RequestParam String password,
                           @RequestParam String role) {

        if (userRepository.findByEmail(email).isPresent()) {
            return "redirect:/auth/register?error=Email already in use";
        }

        User user = new User();
        user.setNom(nom);
        user.setPrenom(prenom);
        user.setEmail(email);
        user.setPassword(password); // Enregistrer le mot de passe sans cryptage pour simplification
        user.setRole(Role.valueOf(role.toUpperCase())); // Définir le rôle en fonction de l'input

        userRepository.save(user);

        return "redirect:/auth/login";
    }

    // Login de l'utilisateur sans sécurité avancée
    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, Model model) {
        User user = userRepository.findByEmail(email).orElse(null);

        if (user == null || !user.getPassword().equals(password)) {
            model.addAttribute("error", "Email ou mot de passe incorrect");
            return "login1";
        }

        // Redirection vers le dashboard en fonction du rôle
        switch (user.getRole()) {
            case ADMIN:
                return "redirect:/admin/dashboard";
            case MEDECIN:
                return "redirect:/medecin/dashboard";
            case PATIENT:
                return "redirect:/patient/dashboard";
            default:
                return "redirect:/auth/login";
        }
    }
}
