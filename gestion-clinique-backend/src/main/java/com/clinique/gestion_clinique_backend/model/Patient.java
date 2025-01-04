package com.clinique.gestion_clinique_backend.model;

import com.clinique.gestion_clinique_backend.enums.Role;
import jakarta.persistence.*;

@Entity
@Table(name = "patients") // Table spécifique pour Patient
public class Patient extends User {

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    public Patient() {
        // Assigner le rôle par défaut
        setRole(Role.PATIENT);
    }

    // Getters et setters

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
