package com.jd.cabinetmedical.controllers;

import com.jd.cabinetmedical.interfaces.AdresseService;
import com.jd.cabinetmedical.models.Adresse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("api/adresses")
public class AdresseController {

    private static Logger LOGGER = LoggerFactory.getLogger(PatientController.class);
    private AdresseService adresseService;

    public AdresseController(AdresseService adresseService) {
        this.adresseService = adresseService;
    }

    @GetMapping
    public List<Adresse> findAll() {
        LOGGER.info("Récupération de toutes les adresses");
        return this.adresseService.findAll();
    }

    @GetMapping("{id}")
    public Optional<Adresse> getAdresseById(@PathVariable Integer id) {
        LOGGER.info("Récupération de l'adresse ayant l'id n° " + id);
        return this.adresseService.findById(id);
    }

    @PostMapping
    public Adresse create(@RequestBody Adresse a) {
        LOGGER.info("Création d'une nouvelle adresse");
        this.adresseService.save(a);
        return a;
    }

    @PutMapping
    public Adresse update(@RequestBody Adresse a) {
        LOGGER.info("Modification des données de l'adresse n° " + a.getId());
        this.adresseService.save(a);
        return a;
    }

    @DeleteMapping("{id}")
    public void deleteAdresseById(@PathVariable Integer id) {
        LOGGER.info("Suppression de l'adresse ayant l'id n° " + id);
        this.adresseService.deleteById(id);
    }
}
