package com.jd.cabinetmedical.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jd.cabinetmedical.enums.Sexe;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "patient")
public class Patient {

    // Ceci est un commentaire très pertinent

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "adresse_id", referencedColumnName = "id")
    private Adresse adresse;

    @ManyToOne
    @JsonIgnoreProperties(value = {"adresse", "patients", "deplacements"}, allowSetters = true)
    private Infirmiere infirmiere;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "date_de_naissance")
    private LocalDate date_de_naissance;

    @Column(columnDefinition = "ENUM('Homme', 'Femme', 'Autre'")
    @Enumerated(EnumType.STRING)
    private Sexe sexe;

    @Column(name = "numero_securite_sociale")
    private Long numero_securite_sociale;

    @OneToMany
    @JsonIgnoreProperties(value = "patient", allowSetters = true)
    private Set<Deplacement> deplacements;
}
