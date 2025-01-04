package com.clinique.gestion_clinique_backend.model;

import com.clinique.gestion_clinique_backend.enums.Role;
import jakarta.persistence.*;
import java.util.List;


@Entity
@Table(name = "patients") // Table spécifique pour Patient
public class Patient extends User {

    @OneToMany(mappedBy = "patient")
    private List<Rendezvous> rendezvous;

    public Patient() {
        // Le rôle par défaut est Patient
        setRole(Role.PATIENT);
    }

    public List<Rendezvous> getRendezvous() {
        return rendezvous;
    }

    public void setRendezvous(List<Rendezvous> rendezvous) {
        this.rendezvous = rendezvous;
    }
}
