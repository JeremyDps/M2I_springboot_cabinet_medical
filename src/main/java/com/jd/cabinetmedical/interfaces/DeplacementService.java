package com.jd.cabinetmedical.interfaces;


import com.jd.cabinetmedical.models.Deplacement;

import java.util.List;

public interface DeplacementService {

    public List<Deplacement> findAll();

    public Deplacement save(Deplacement d);

    public Deplacement findById(Integer id);

    public Deplacement update(Deplacement d);

    public void deleteById(Integer id);
}
