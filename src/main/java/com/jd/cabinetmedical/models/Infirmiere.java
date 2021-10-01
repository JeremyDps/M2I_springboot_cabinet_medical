package com.jd.cabinetmedical.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data@NoArgsConstructor
@AllArgsConstructor
@Table(name = "infirmiere")
public class Infirmiere {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToMany
    private Set<Adresse> adresses;

    @Column(name = "numero_professionnel")
    private int numero_professionnel;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;;

    @Column(name = "tel_pro")
    private String tel_pro;

    @Column(name = "tel_perso")
    private String tel_perso;

    @OneToMany
    private Set<Patient> patients;

    @OneToMany
    private Set<Deplacement> deplacements;
}
