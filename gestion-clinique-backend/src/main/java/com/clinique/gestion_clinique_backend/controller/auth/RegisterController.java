package com.clinique.gestion_clinique_backend.controller.auth;

import com.clinique.gestion_clinique_backend.model.User;
import com.clinique.gestion_clinique_backend.repository.UserRepository;
import com.clinique.gestion_clinique_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User()); // Créer un nouvel objet User vide
        return "register"; // Retourner le nom de la vue sans le "/"
    }

    @PostMapping
    public String register(User user, Model model) {
        // Vérification des mots de passe
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            model.addAttribute("error", "Les mots de passe ne correspondent pas.");
            return "register"; // Retourner à la vue d'inscription
        }

        // Vérification de l'existence de l'email
        if (userRepository.existsByEmail(user.getEmail())) {
            model.addAttribute("error", "Cet email est déjà utilisé.");
            return "register"; // Retourner à la vue d'inscription
        }

        // Hacher le mot de passe
        user.setPassword(userService.encodePassword(user.getPassword()));

        // Sauvegarder l'utilisateur dans la base de données
        userRepository.save(user);

        return "redirect:/login"; // Rediriger vers la page de connexion après l'inscription
    }
}
