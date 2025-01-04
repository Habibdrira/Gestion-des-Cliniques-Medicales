package com.clinique.gestion_clinique_backend.model;
import com.clinique.gestion_clinique_backend.enums.Role;
import jakarta.persistence.*;

@Entity
@Table(name = "medecins") // Table spécifique pour Medecin
public class Medecin extends User {

    @Column(nullable = false)
    private String specialite;

    @Column(nullable = false)
    private String numLicence;

    public Medecin() {
        // Assigner le rôle par défaut
        setRole(Role.MEDECIN);
    }

    // Getters et setters

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String getNumLicence() {
        return numLicence;
    }

    public void setNumLicence(String numLicence) {
        this.numLicence = numLicence;
    }
}
