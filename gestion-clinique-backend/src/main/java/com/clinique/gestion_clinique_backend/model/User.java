package com.clinique.gestion_clinique_backend.model;

import com.clinique.gestion_clinique_backend.enums.Role;
import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) // Stratégie JOINED pour l'héritage
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false ,unique = true )
    @jakarta.validation.constraints.Email
    private String email;

    @Column(nullable = false)
    @jakarta.validation.constraints.Size(min = 6, message = "Le mot de passe doit avoir au moins 6 caractères.")
    private String password;
    @Transient
    private String confirmPassword;

    @Enumerated(EnumType.STRING) // Utilisation de l'énumération comme chaîne
    @Column(nullable = false)
    private Role role;

    // Informations communes
    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;



    // Getters et setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }


}
