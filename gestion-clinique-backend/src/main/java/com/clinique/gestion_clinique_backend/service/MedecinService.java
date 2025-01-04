package com.clinique.gestion_clinique_backend.service;

import com.clinique.gestion_clinique_backend.model.Medecin;
import com.clinique.gestion_clinique_backend.repository.MedecinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class MedecinService {

    @Autowired
    private MedecinRepository medecinRepository;

    public Medecin getMedecinById(Long id) {
        Optional<Medecin> medecin = medecinRepository.findById(id);
        return medecin.orElse(null);  // Retourne null si le médecin n'est pas trouvé
    }

    // Méthode pour créer un médecin
    public Medecin createMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }
}
