package com.clinique.gestion_clinique_backend.service;
import org.springframework.stereotype.Service;
import com.clinique.gestion_clinique_backend.repository.*;
import com.clinique.gestion_clinique_backend.model.*;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class RendezvousService {

    @Autowired
    private RendezvousRepository rendezvousRepository;

    public Rendezvous createRendezvous(Medecin medecin, Patient patient, LocalDateTime dateHeure) {
        Rendezvous rendezvous = new Rendezvous();
        rendezvous.setMedecin(medecin);
        rendezvous.setPatient(patient);
        rendezvous.setDateHeure(dateHeure);
        return rendezvousRepository.save(rendezvous);
    }

    public List<Rendezvous> getRendezvousByMedecin(Medecin medecin) {
        return rendezvousRepository.findByMedecin(medecin);
    }

    public List<Rendezvous> getRendezvousByPatient(Patient patient) {
        return rendezvousRepository.findByPatient(patient);
    }
}
