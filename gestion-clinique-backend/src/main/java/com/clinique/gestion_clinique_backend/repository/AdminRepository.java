package com.clinique.gestion_clinique_backend.repository;

import com.clinique.gestion_clinique_backend.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    // Vous pouvez ajouter des méthodes spécifiques à Admin si nécessaire
}
