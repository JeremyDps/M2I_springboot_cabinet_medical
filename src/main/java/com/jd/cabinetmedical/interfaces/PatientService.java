package com.jd.cabinetmedical.interfaces;

import com.jd.cabinetmedical.models.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService {

    public List<Patient> findAll();

    public Patient save(Patient p);

    public Optional<Patient> findById(Integer id);

    public Patient update(Patient p);

    public void deleteById(Integer id);

}
