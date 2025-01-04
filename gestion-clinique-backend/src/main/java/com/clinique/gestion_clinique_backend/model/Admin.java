package com.clinique.gestion_clinique_backend.model;

import com.clinique.gestion_clinique_backend.enums.Role;


import jakarta.persistence.*;

@Entity
@Table(name = "admins") // Table spécifique pour Admin
public class Admin extends User {

    @Column(nullable = false)
    private String roleName;

    public Admin() {
        // Assigner le rôle par défaut
        setRole(Role.ADMIN);
    }

    // Getters et setters

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
