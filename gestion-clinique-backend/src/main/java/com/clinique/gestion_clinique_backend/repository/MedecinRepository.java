package com.clinique.gestion_clinique_backend.repository;

import com.clinique.gestion_clinique_backend.model.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {
    // Méthodes spécifiques à Medecin, si nécessaire
}
