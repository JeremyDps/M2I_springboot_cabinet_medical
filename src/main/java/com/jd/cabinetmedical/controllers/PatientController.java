package com.jd.cabinetmedical.controllers;

import com.jd.cabinetmedical.interfaces.PatientService;
import com.jd.cabinetmedical.models.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("api/patients")
public class PatientController {

    private static Logger LOGGER = LoggerFactory.getLogger(PatientController.class);
    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public List<Patient> findAll() {
        LOGGER.info("Récupération de tous les patients");
        return this.patientService.findAll();
    }

    @GetMapping("{id}")
    public Optional<Patient> getPatientById(@PathVariable Integer id) {
        LOGGER.info("Récupération du patient ayant l'id n° " + id);
        return this.patientService.findById(id);
    }

    @PostMapping
    public Patient create(@RequestBody Patient p) {
        LOGGER.info("Création d'un nouveau patient");
        this.patientService.save(p);
        return p;
    }

    @PutMapping
    public Patient update(@RequestBody Patient p) {
        LOGGER.info("Modification des données du patient n° " + p.getId());
        this.patientService.save(p);
        return p;
    }

    @DeleteMapping("{id}")
    public void deletePatientById(@PathVariable Integer id) {
        LOGGER.info("Suppression du patient ayant l'id n° " + id);
        this.patientService.deleteById(id);
    }


}
