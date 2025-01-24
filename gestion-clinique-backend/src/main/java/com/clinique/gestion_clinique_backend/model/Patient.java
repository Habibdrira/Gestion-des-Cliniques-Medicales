package com.clinique.gestion_clinique_backend.model;

import com.clinique.gestion_clinique_backend.enums.Role;
import jakarta.persistence.*;
import java.util.List;


@Entity
@Table(name = "patients") // Table spécifique pour Patient
public class Patient extends User {


}
