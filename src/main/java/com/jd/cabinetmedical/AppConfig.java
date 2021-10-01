package com.jd.cabinetmedical;

import com.jd.cabinetmedical.interfaces.AdresseService;
import com.jd.cabinetmedical.interfaces.DeplacementService;
import com.jd.cabinetmedical.interfaces.InfirmiereService;
import com.jd.cabinetmedical.interfaces.PatientService;
import com.jd.cabinetmedical.repositories.AdresseRepository;
import com.jd.cabinetmedical.repositories.DeplacementRepository;
import com.jd.cabinetmedical.repositories.InfirmiereRepository;
import com.jd.cabinetmedical.repositories.PatientRepository;
import com.jd.cabinetmedical.services.AdresseServiceImpl;
import com.jd.cabinetmedical.services.DeplacementServiceImpl;
import com.jd.cabinetmedical.services.InfirmiereServiceImpl;
import com.jd.cabinetmedical.services.PatientServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public PatientService patientService(PatientRepository patientRepository) {
        return new PatientServiceImpl(patientRepository);
    }

    @Bean
    public AdresseService adresseService(AdresseRepository adresseRepository) {
        return new AdresseServiceImpl(adresseRepository);
    }

    @Bean
    public InfirmiereService infirmiereService(InfirmiereRepository infirmiereRepository) {
        return new InfirmiereServiceImpl(infirmiereRepository);
    }

    @Bean
    public DeplacementService deplacementService(DeplacementRepository deplacementRepository) {
        return new DeplacementServiceImpl(deplacementRepository);
    }
}
