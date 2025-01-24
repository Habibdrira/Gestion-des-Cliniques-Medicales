package com.clinique.gestion_clinique_backend.repository;

import com.clinique.gestion_clinique_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    // Recherche un utilisateur par son email
    User findByEmail(String email);

    // Vérifie si l'email existe déjà dans la base de données
    boolean existsByEmail(String email);
}


