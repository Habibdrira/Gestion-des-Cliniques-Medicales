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
import com.clinique.gestion_clinique_backend.model.*;
import com.clinique.gestion_clinique_backend.repository.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Controller
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register/patient")
    public String registerPatient(@RequestParam String nom,
                                  @RequestParam String prenom,
                                  @RequestParam String email,
                                  @RequestParam String password) {
        Patient patient = new Patient();
        patient.setNom(nom);
        patient.setPrenom(prenom);
        patient.setEmail(email); // Utilisez setEmail() au lieu de setUsername()
        patient.setPassword(password); // Hachage du mot de passe si nécessaire
        patient.setRole(Role.PATIENT);

        userRepository.save(patient);
        return "Patient registered successfully!";
    }
}
