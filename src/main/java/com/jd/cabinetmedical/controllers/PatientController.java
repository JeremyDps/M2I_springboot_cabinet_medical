package com.jd.cabinetmedical.controllers;

import com.jd.cabinetmedical.interfaces.AdresseService;
import com.jd.cabinetmedical.interfaces.InfirmiereService;
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
    private AdresseService adresseService;
    private InfirmiereService infirmiereService;

    public PatientController(PatientService patientService, AdresseService adresseService, InfirmiereService infirmiereService) {
        this.patientService = patientService;
        this.adresseService = adresseService;
        this.infirmiereService = infirmiereService;
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

        if (!p.getAdresse().equals(null)) {
            LOGGER.info("On commence par enregistrer l'adresse");
            /*Set<Infirmiere> infirmieres = new HashSet<Infirmiere>();
            infirmieres.add(i);
            i.getAdresse().setInfirmieres(infirmieres);*/
            this.adresseService.save(p.getAdresse());
        }

        if(!p.getInfirmiere().equals(null)) {
            LOGGER.info("On commence par enregistrer l'infirmière");
            this.infirmiereService.save(p.getInfirmiere());
        }

        this.patientService.save(p);
        return p;
    }

    @PutMapping
    public Patient update(@RequestBody Patient p) {
        LOGGER.info("Modification des données du patient n° " + p.getId());

        if (!p.getAdresse().equals(null)) {
            LOGGER.info("On commence par modifier l'adresse");
            /*Set<Infirmiere> infirmieres = new HashSet<Infirmiere>();
            infirmieres.add(i);
            i.getAdresse().setInfirmieres(infirmieres);*/
            this.adresseService.save(p.getAdresse());
        }

        this.patientService.save(p);
        return p;
    }

    @DeleteMapping("{id}")
    public void deletePatientById(@PathVariable Integer id) {
        LOGGER.info("Suppression du patient ayant l'id n° " + id);
        this.patientService.deleteById(id);
    }


}
