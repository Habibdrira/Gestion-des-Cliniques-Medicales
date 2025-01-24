package com.clinique.gestion_clinique_backend.controller.auth;

import com.clinique.gestion_clinique_backend.model.User;
import com.clinique.gestion_clinique_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public String loginPage() {
        return "/loginn"; // Assurez-vous que vous avez une page login.html dans le répertoire resources/templates
    }

    @PostMapping
    public void login(@RequestParam String email, @RequestParam String password,
                      HttpServletRequest request, HttpServletResponse response) throws IOException {

        // Rechercher l'utilisateur par email
        User user = userService.findByEmail(email);

        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            // Authentification réussie, redirection basée sur le rôle de l'utilisateur
            if (user.getRole().toString().equals("ADMIN")) {
                response.sendRedirect("/admin/dashboard");
            } else if (user.getRole().toString().equals("DOCTOR")) {
                response.sendRedirect("/doctor/dashboard");
            } else if (user.getRole().toString().equals("PATIENT")) {
                response.sendRedirect("/patient/dashboard");
            }
        } else {
            // Authentification échouée
            response.sendRedirect("/login?error=true");
        }
    }
}
