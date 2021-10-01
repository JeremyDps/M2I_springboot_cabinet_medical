package com.jd.cabinetmedical.interfaces;

import com.jd.cabinetmedical.models.Adresse;

import java.util.List;
import java.util.Optional;

public interface AdresseService {

    public List<Adresse> findAll();

    public Adresse save(Adresse a);

    public Optional<Adresse> findById(Integer id);

    public Adresse update(Adresse a);

    public void deleteById(Integer id);
}
