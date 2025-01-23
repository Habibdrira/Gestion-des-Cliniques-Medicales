package com.clinique.gestion_clinique_backend.repository;

import com.clinique.gestion_clinique_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    // Recherche un utilisateur par son email
    boolean existsByEmail(String email);
}

