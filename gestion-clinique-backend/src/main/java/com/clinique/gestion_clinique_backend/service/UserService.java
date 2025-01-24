package com.clinique.gestion_clinique_backend.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.clinique.gestion_clinique_backend.model.User;
import com.clinique.gestion_clinique_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserService {

    private final PasswordEncoder passwordEncoder;

    public UserService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
    @Autowired
    private UserRepository userRepository;

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    // Méthode pour encoder le mot de passe
    public String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }
}
