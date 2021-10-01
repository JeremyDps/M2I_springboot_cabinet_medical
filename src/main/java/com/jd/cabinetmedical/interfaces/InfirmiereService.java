package com.jd.cabinetmedical.interfaces;


import com.jd.cabinetmedical.models.Infirmiere;

import java.util.List;
import java.util.Optional;

public interface InfirmiereService {

    public List<Infirmiere> findAll();

    public Infirmiere save(Infirmiere i);

    public Optional<Infirmiere> findById(Integer id);

    public Infirmiere update(Infirmiere i);

    public void deleteById(Integer id);
}
