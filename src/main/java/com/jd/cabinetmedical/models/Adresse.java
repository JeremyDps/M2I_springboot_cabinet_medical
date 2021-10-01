package com.jd.cabinetmedical.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "adresse")
public class Adresse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "numero")
    private String numero;

    @Column(name = "rue")
    private String rue;

    @Column(name = "cp")
    private String cp;

    @Column(name = "ville")
    private String ville;

    /*@OneToMany
    //@JsonIgnoreProperties(value = "infirmiere", allowSetters = true)
    private Set<Patient> patients;

    @OneToMany
    //@JsonIgnoreProperties(value = "patients", allowSetters = true)
    private Set<Infirmiere> infirmieres;*/
}
