package com.clinique.gestion_clinique_backend.service;

import com.clinique.gestion_clinique_backend.dto.RegisterRequest;
import com.clinique.gestion_clinique_backend.enums.Role;
import com.clinique.gestion_clinique_backend.model.User;
import com.clinique.gestion_clinique_backend.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public String register(RegisterRequest request) {
        // Vérification si l'email existe déjà
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Cet email est déjà utilisé.");
        }

        // Création d'un nouvel utilisateur
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setNom(request.getNom());
        user.setPrenom(request.getPrenom());
        user.setAdresse(request.getAdresse());
        user.setTelephone(request.getTelephone());
        user.setRole(request.getRole() != null ? request.getRole() : Role.PATIENT); // Rôle par défaut

        // Sauvegarde de l'utilisateur
        userRepository.save(user);

        return "Utilisateur enregistré avec succès.";
    }
}
