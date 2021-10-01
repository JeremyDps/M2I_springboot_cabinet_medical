package com.jd.cabinetmedical.services;

import com.jd.cabinetmedical.interfaces.InfirmiereService;
import com.jd.cabinetmedical.models.Infirmiere;

import java.util.List;

public class InfirmiereServiceImpl implements InfirmiereService {

    private InfirmiereRepository infirmiereRepository;

    public InfirmiereServiceImpl(InfirmiereRepository infirmiereRepository) {
        this.infirmiereRepository = infirmiereRepository;
    }

    @Override
    public List<Infirmiere> findAll() {
        return this.infirmiereRepository.findAll();
    }

    @Override
    public Infirmiere save(Infirmiere i) {
        this.infirmiereRepository.save(i);
        return i;
    }

    @Override
    public Infirmiere findById(Integer id) {
        return this.infirmiereRepository.findById(id);
    }

    @Override
    public Infirmiere update(Infirmiere i) {
        this.infirmiereRepository.save(i);
        return i;
    }

    @Override
    public void deleteById(Integer id) {
        this.infirmiereRepository.deleteyId(id);
    }
}
