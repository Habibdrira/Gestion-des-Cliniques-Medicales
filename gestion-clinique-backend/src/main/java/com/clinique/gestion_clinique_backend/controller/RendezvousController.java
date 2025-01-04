package com.clinique.gestion_clinique_backend.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import com.clinique.gestion_clinique_backend.service.*;
import com.clinique.gestion_clinique_backend.model.*;
import com.clinique.gestion_clinique_backend.dto.*;

@RestController
@RequestMapping("/api/rendezvous")
public class RendezvousController {

    @Autowired
    private RendezvousService rendezvousService;

    @Autowired
    private MedecinService medecinService;

    @Autowired
    private PatientService patientService;

    @PostMapping("/create")
    public ResponseEntity<?> createRendezvous(@RequestBody RendezvousDTO dto) {
        Medecin medecin = medecinService.getMedecinById(dto.getMedecinId());
        Patient patient = patientService.getPatientById(dto.getPatientId());

        if (medecin == null || patient == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Medecin or Patient not found");
        }

        var rendezvous = rendezvousService.createRendezvous(medecin, patient, dto.getDateHeure());
        return ResponseEntity.status(HttpStatus.CREATED).body(rendezvous);
    }

    @GetMapping("/medecin/{medecinId}")
    public ResponseEntity<?> getRendezvousByMedecin(@PathVariable Long medecinId) {
        Medecin medecin = medecinService.getMedecinById(medecinId);
        if (medecin == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Medecin not found");
        }
        return ResponseEntity.ok(rendezvousService.getRendezvousByMedecin(medecin));
    }
}
