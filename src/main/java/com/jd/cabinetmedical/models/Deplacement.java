package com.jd.cabinetmedical.models;

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

    @OneToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    private Patient patient;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "cout")
    private Double cout;

    @OneToOne
    @JoinColumn(name = "infirmiere_id", referencedColumnName = "id")
    private Infirmiere infirmiere;

}
