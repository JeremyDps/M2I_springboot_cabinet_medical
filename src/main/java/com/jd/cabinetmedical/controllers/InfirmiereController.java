package com.jd.cabinetmedical.controllers;

import com.jd.cabinetmedical.interfaces.AdresseService;
import com.jd.cabinetmedical.interfaces.InfirmiereService;
import com.jd.cabinetmedical.interfaces.PatientService;
import com.jd.cabinetmedical.models.Infirmiere;
import com.jd.cabinetmedical.models.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin
@RequestMapping("api/infirmieres")
public class InfirmiereController {

    private static Logger LOGGER = LoggerFactory.getLogger(PatientController.class);
    private InfirmiereService infirmiereService;
    private AdresseService adresseService;
    private PatientService patientService;

    public InfirmiereController(InfirmiereService infirmiereService, AdresseService adresseService, PatientService patientService) {
        this.infirmiereService = infirmiereService;
        this.adresseService = adresseService;
        this.patientService = patientService;
    }

    @GetMapping
    public List<Infirmiere> findAll() {
        LOGGER.info("Récupération de toutes les infirmières");
        return this.infirmiereService.findAll();
    }

    @GetMapping("{id}")
    public Optional<Infirmiere> getInfirmiereById(@PathVariable Integer id) {
        LOGGER.info("Récupération de l'infirmière ayant l'id n° " + id);
        return this.infirmiereService.findById(id);
    }

    @PostMapping
    public Infirmiere create(@RequestBody Infirmiere i) {
        LOGGER.info("Création d'une nouvelle infirmière");

        Set<Patient> patientsEnregistres = new HashSet<Patient>();

        if (!i.getAdresse().equals(null)) {
            LOGGER.info("On commence par enregistrer l'adresse");
            /*Set<Infirmiere> infirmieres = new HashSet<Infirmiere>();
            infirmieres.add(i);
            i.getAdresse().setInfirmieres(infirmieres);*/
            this.adresseService.save(i.getAdresse());
        }

        if(!i.getPatients().equals(null)) {
            LOGGER.info("on commence par enregistrer les patients" + i.getPatients());

            for(Patient patient: i.getPatients()) {
                this.patientService.save(patient);
            }
        }

        this.infirmiereService.save(i);
        return i;
    }

    @PutMapping
    public Infirmiere update(@RequestBody Infirmiere i) {
        LOGGER.info("Modification des données de l'infirmière n° " + i.getId());

        if (!i.getAdresse().equals(null)) {
            LOGGER.info("On commence par enregistrer l'adresse");
            /*Set<Infirmiere> infirmieres = new HashSet<Infirmiere>();
            infirmieres.add(i);
            i.getAdresse().setInfirmieres(infirmieres);*/
            this.adresseService.save(i.getAdresse());
        }

        this.infirmiereService.save(i);
        return i;
    }

    @DeleteMapping("{id}")
    public void deleteInfirmiereById(@PathVariable Integer id) {
        LOGGER.info("Suppression de l'infirmière ayant l'id n° " + id);
        this.infirmiereService.deleteById(id);
    }
}
