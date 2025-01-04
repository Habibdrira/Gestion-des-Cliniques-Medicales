package com.clinique.gestion_clinique_backend.controller;

import com.clinique.gestion_clinique_backend.model.Medecin;
import com.clinique.gestion_clinique_backend.service.MedecinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/medecins")
public class MedecinController {

    @Autowired
    private MedecinService medecinService;

    // Méthode pour afficher le formulaire de création de médecin
    @RequestMapping("/create")
    public String showCreateMedecinForm() {
        return "create_medecin";  // Formulaire HTML de création de médecin
    }

    // Méthode pour créer un médecin

    @PostMapping("/create")
    public String createMedecin(@RequestParam String nom, @RequestParam String prenom,
                                @RequestParam String email, @RequestParam String specialite,
                                @RequestParam String numLicence, Model model) {
        // Validation simple des champs
        if (nom.isEmpty() || prenom.isEmpty() || email.isEmpty() || specialite.isEmpty() || numLicence.isEmpty()) {
            model.addAttribute("message", "Tous les champs doivent être remplis.");
            return "create_medecin";  // Retourne au formulaire si des champs sont vides
        }

        Medecin medecin = new Medecin();
        medecin.setNom(nom);
        medecin.setPrenom(prenom);
        medecin.setEmail(email);
        medecin.setSpecialite(specialite);
        medecin.setNumLicence(numLicence);

        // Sauvegarder le médecin dans la base de données
        medecinService.createMedecin(medecin);

        model.addAttribute("message", "Médecin créé avec succès!");
        return "medecin_created";  // Affiche un message de succès
    }

}
