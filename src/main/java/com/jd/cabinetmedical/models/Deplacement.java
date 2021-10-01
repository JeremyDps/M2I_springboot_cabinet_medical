package com.jd.cabinetmedical.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "deplacement")
public class Deplacement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    @JsonIgnoreProperties(value = "infirmiere", allowSetters = true)
    private Patient patient;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "cout")
    private Double cout;

    @ManyToOne
    @JoinColumn(name = "infirmiere_id", referencedColumnName = "id")
    @JsonIgnoreProperties(value = "patients", allowSetters = true)
    private Infirmiere infirmiere;

}
