package com.jd.cabinetmedical.controllers;

import com.jd.cabinetmedical.interfaces.DeplacementService;
import com.jd.cabinetmedical.models.Deplacement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("api/deplacements")
public class DeplacementController {

    private static Logger LOGGER = LoggerFactory.getLogger(PatientController.class);
    private DeplacementService deplacementService;

    public DeplacementController(DeplacementService deplacementService) {
        this.deplacementService = deplacementService;
    }

    @GetMapping
    public List<Deplacement> findAll() {
        LOGGER.info("Récupération de tous les déplacements");
        return this.deplacementService.findAll();
    }

    @GetMapping("{id}")
    public Optional<Deplacement> getDeplacementById(@PathVariable Integer id) {
        LOGGER.info("Récupération du déplacement ayant l'id n° " + id);
        return this.deplacementService.findById(id);
    }

    @PostMapping
    public Deplacement create(@RequestBody Deplacement d) {
        LOGGER.info("Création d'un nouveau déplacement");
        this.deplacementService.save(d);
        return d;
    }

    @PutMapping
    public Deplacement update(@RequestBody Deplacement d) {
        LOGGER.info("Modification du déplacement n° " + d.getId());
        this.deplacementService.save(d);
        return d;
    }

    @DeleteMapping("{id}")
    public void deleteDeplacementById(@PathVariable Integer id) {
        LOGGER.info("Suppression du déplacement ayant l'id n° " + id);
        this.deplacementService.deleteById(id);
    }
}
