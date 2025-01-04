package com.clinique.gestion_clinique_backend.model;

import com.clinique.gestion_clinique_backend.enums.Role;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity

public class PlanningMedecin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "medecin_id", nullable = false)
    private Medecin medecin;

    private LocalDateTime disponibiliteDebut;  // Heure de début de disponibilité
    private LocalDateTime disponibiliteFin;    // Heure de fin de disponibilité

    // Getters et Setters
}
