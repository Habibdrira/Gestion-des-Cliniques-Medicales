package com.clinique.gestion_clinique_backend.controller;

import com.clinique.gestion_clinique_backend.enums.Role;
import com.clinique.gestion_clinique_backend.model.Patient;
import com.clinique.gestion_clinique_backend.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Controller
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    // Méthode pour afficher le formulaire de création de patient
    @RequestMapping("/create")
    public String showCreatePatientForm() {
        return "create_patient";  // Formulaire HTML de création de patient
    }

    // Méthode pour créer un patient
    @PostMapping("/create")
    public String createPatient(@RequestParam String nom, @RequestParam String prenom,
                                @RequestParam String email, @RequestParam String adresse,
                                @RequestParam String telephone, @RequestParam String motDePasse, Model model) {
        // Validation simple des champs
        if (nom.isEmpty() || prenom.isEmpty() || email.isEmpty() || adresse.isEmpty() || telephone.isEmpty() || motDePasse.isEmpty()) {
            model.addAttribute("message", "Tous les champs doivent être remplis.");
            return "create_patient";  // Retourne au formulaire si des champs sont vides
        }

        // Vérification de l'unicité du nom d'utilisateur et de l'email
        if (patientService.existsByUsername(nom) || patientService.existsByEmail(email)) {
            model.addAttribute("message", "Nom d'utilisateur ou email déjà existants.");
            return "create_patient";  // Retourner au formulaire si doublon
        }

        // Hachage du mot de passe (utilisation de SHA-256 ici)
        String motDePasseHache = hashPassword(motDePasse);

        // Créer un patient avec les données
        Patient patient = new Patient();
        patient.setNom(nom);
        patient.setPrenom(prenom);
        patient.setEmail(email);
        patient.setAdresse(adresse);
        patient.setTelephone(telephone);
        patient.setPassword(motDePasseHache); // Sauvegarder le mot de passe haché
        patient.setUsername(nom);  // Vous pouvez aussi personnaliser le username
        patient.setRole(Role.PATIENT);  // Le rôle par défaut pour les patients

        // Sauvegarder le patient dans la base de données
        patientService.createPatient(patient);

        model.addAttribute("message", "Patient créé avec succès!");
        return "patient_created";  // Affiche un message de succès
    }

    // Méthode pour hacher le mot de passe
    private String hashPassword(String motDePasse) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(motDePasse.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashedBytes) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Erreur lors du hachage du mot de passe", e);
        }
    }
}
