package com.jd.cabinetmedical.interfaces;

import com.jd.cabinetmedical.models.Adresse;

import java.util.List;

public interface AdresseService {

    public List<Adresse> findAll();

    public Adresse save(Adresse a);

    public Adresse findById(Integer id);

    public Adresse update(Adresse a);

    public void deleteById(Integer id);
}
