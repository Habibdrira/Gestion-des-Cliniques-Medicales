package com.clinique.gestion_clinique_backend.model;
import com.clinique.gestion_clinique_backend.enums.Role;
import jakarta.persistence.*;
import java.util.List;


@Entity
@Table(name = "medecins") // Table spécifique pour Medecin
public class Medecin extends User {

    @Column(nullable = false)
    private String specialite;

    @Column(nullable = false)
    private String numLicence;

    @OneToMany(mappedBy = "medecin")
    private List<Rendezvous> rendezvous;

    @OneToOne(mappedBy = "medecin")
    private PlanningMedecin planningMedecin;

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

    public List<Rendezvous> getRendezvous() {
        return rendezvous;
    }

    public void setRendezvous(List<Rendezvous> rendezvous) {
        this.rendezvous = rendezvous;
    }

    public PlanningMedecin getPlanningMedecin() {
        return planningMedecin;
    }

    public void setPlanningMedecin(PlanningMedecin planningMedecin) {
        this.planningMedecin = planningMedecin;
    }
}
