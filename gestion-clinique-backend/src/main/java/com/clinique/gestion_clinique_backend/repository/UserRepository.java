package com.clinique.gestion_clinique_backend.repository;

import com.clinique.gestion_clinique_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
