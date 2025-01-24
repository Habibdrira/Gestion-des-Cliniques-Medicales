package com.clinique.gestion_clinique_backend.model;

import com.clinique.gestion_clinique_backend.enums.Role;
import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "Rendezvous")
public class Rendezvous {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "medecin_id", nullable = true)
    private Medecin medecin;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = true)
    private Patient patient;

    private LocalDateTime dateHeure;  // Date et heure du rendez-vous

    // Getters et Setters




        // Other fields and methods

        public Medecin getMedecin() {
            return medecin;
        }

        public void setMedecin(Medecin medecin) {
            this.medecin = medecin;
        }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    public LocalDateTime getDateHeure() {
        return dateHeure;
    }

    public void setDateHeure(LocalDateTime dateHeure) {
        this.dateHeure = dateHeure;
    }

}
