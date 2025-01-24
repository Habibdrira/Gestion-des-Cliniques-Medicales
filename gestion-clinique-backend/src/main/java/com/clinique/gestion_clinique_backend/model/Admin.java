package com.clinique.gestion_clinique_backend.model;

import com.clinique.gestion_clinique_backend.enums.Role;


import jakarta.persistence.*;

@Entity
@Table(name = "admins") // Table spécifique pour Admin
public class Admin extends User {


}
