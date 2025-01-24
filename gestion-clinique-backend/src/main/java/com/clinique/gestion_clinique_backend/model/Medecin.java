package com.clinique.gestion_clinique_backend.model;
import com.clinique.gestion_clinique_backend.enums.Role;
import jakarta.persistence.*;
import java.util.List;


@Entity
@Table(name = "medecins") // Table spécifique pour Medecin
public class Medecin extends User {

}
