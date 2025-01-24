package com.clinique.gestion_clinique_backend.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        // Logique personnalisée à exécuter après une authentification réussie
        // Par exemple, vous pouvez rediriger l'utilisateur vers un dashboard spécifique en fonction de son rôle
        String role = authentication.getAuthorities().toString(); // Obtenez les rôles de l'utilisateur

        // Exemple de redirection selon le rôle
        if (role.contains("ADMIN")) {
            response.sendRedirect("/admin/dashboard");
        } else if (role.contains("DOCTOR")) {
            response.sendRedirect("/doctor/dashboard");
        } else {
            response.sendRedirect("/patient/dashboard");
        }
    }
}
