package com.jd.cabinetmedical.services;

import com.jd.cabinetmedical.interfaces.AdresseService;
import com.jd.cabinetmedical.models.Adresse;
import com.jd.cabinetmedical.repositories.AdresseRepository;

import java.util.List;
import java.util.Optional;

public class AdresseServiceImpl implements AdresseService {

    private AdresseRepository adresseRepository;

    public AdresseServiceImpl(AdresseRepository adresseRepository) {
        this.adresseRepository = adresseRepository;
    }

    @Override
    public List<Adresse> findAll() {
        return this.adresseRepository.findAll();
    }

    @Override
    public Adresse save(Adresse a) {

        List<Adresse> adressesExistantes = this.adresseRepository.findAll();

        if(!adressesExistantes.equals(null)) {
            for(Adresse adresse: adressesExistantes) {
                if(adresse.getCp() == a.getCp()
                    && adresse.getNumero() == a.getNumero()
                    && adresse.getRue() == a.getRue()
                    && adresse.getVille() == a.getVille()) {
                    return null;
                }
            }
        }

        this.adresseRepository.save(a);
        return a;
    }

    @Override
    public Optional<Adresse> findById(Integer id) {
        return this.adresseRepository.findById(id);
    }

    @Override
    public Adresse update(Adresse a) {

        List<Adresse> adressesExistantes = this.adresseRepository.findAll();

        if(!adressesExistantes.equals(null)) {
            for(Adresse adresse: adressesExistantes) {
                if(adresse.getCp() == a.getCp()
                        && adresse.getNumero() == a.getNumero()
                        && adresse.getRue() == a.getRue()
                        && adresse.getVille() == a.getVille()) {
                    return null;
                }
            }
        }

        this.adresseRepository.save(a);
        return a;
    }

    @Override
    public void deleteById(Integer id) {
        this.adresseRepository.deleteById(id);
    }
}
