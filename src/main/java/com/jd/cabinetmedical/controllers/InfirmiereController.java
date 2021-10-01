package com.jd.cabinetmedical.controllers;

import com.jd.cabinetmedical.interfaces.InfirmiereService;
import com.jd.cabinetmedical.models.Infirmiere;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("api/infirmieres")
public class InfirmiereController {

    private static Logger LOGGER = LoggerFactory.getLogger(PatientController.class);
    private InfirmiereService infirmiereService;

    public InfirmiereController(InfirmiereService infirmiereService) {
        this.infirmiereService = infirmiereService;
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
        this.infirmiereService.save(i);
        return i;
    }

    @PutMapping
    public Infirmiere update(@RequestBody Infirmiere i) {
        LOGGER.info("Modification des données de l'infirmière n° " + i.getId());
        this.infirmiereService.save(i);
        return i;
    }

    @DeleteMapping("{id}")
    public void deleteInfirmiereById(@PathVariable Integer id) {
        LOGGER.info("Suppression de l'infirmière ayant l'id n° " + id);
        this.infirmiereService.deleteById(id);
    }
}
