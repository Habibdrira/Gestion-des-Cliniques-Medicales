package com.clinique.gestion_clinique_backend.service;

import com.clinique.gestion_clinique_backend.model.Patient;
import com.clinique.gestion_clinique_backend.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    // Méthode pour vérifier si le nom d'utilisateur existe déjà


    // Méthode pour vérifier si l'email existe déjà
    public boolean existsByEmail(String email) {
        return patientRepository.existsByEmail(email);
    }

    // Méthode pour créer un patient
    public void createPatient(Patient patient) {
        patientRepository.save(patient);  // Sauvegarder le patient dans la base de données
    }

    public Patient getPatientById(Long id) {
        Optional<Patient> patient = patientRepository.findById(id);
        return patient.orElse(null); // Retourne le patient s'il est trouvé, sinon retourne null
    }
}
