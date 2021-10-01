package com.jd.cabinetmedical.services;

import com.jd.cabinetmedical.interfaces.InfirmiereService;
import com.jd.cabinetmedical.models.Infirmiere;
import com.jd.cabinetmedical.repositories.InfirmiereRepository;

import java.util.List;
import java.util.Optional;

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
    public Optional<Infirmiere> findById(Integer id) {
        return this.infirmiereRepository.findById(id);
    }

    @Override
    public Infirmiere update(Infirmiere i) {
        this.infirmiereRepository.save(i);
        return i;
    }

    @Override
    public void deleteById(Integer id) {
        this.infirmiereRepository.deleteById(id);
    }
}
