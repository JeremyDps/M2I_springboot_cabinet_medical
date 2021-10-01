package com.jd.cabinetmedical.repositories;

import com.jd.cabinetmedical.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
