package com.clinique.gestion_clinique_backend.repository;

import com.clinique.gestion_clinique_backend.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {



    // Vérifier si l'email existe déjà
    boolean existsByEmail(String email);
}
