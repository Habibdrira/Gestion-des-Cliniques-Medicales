package com.clinique.gestion_clinique_backend.repository;
import java.util.List;

import com.clinique.gestion_clinique_backend.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface RendezvousRepository extends JpaRepository<Rendezvous, Long> {
    List<Rendezvous> findByMedecin(Medecin medecin);
    List<Rendezvous> findByPatient(Patient patient);
}
