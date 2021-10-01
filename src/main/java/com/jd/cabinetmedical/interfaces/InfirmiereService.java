package com.jd.cabinetmedical.interfaces;


import com.jd.cabinetmedical.models.Infirmiere;

import java.util.List;

public interface InfirmiereService {

    public List<Infirmiere> findAll();

    public Infirmiere save(Infirmiere i);

    public Infirmiere findById(Integer id);

    public Infirmiere update(Infirmiere i);

    public void deleteById(Integer id);
}
