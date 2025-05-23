package com.evalpro.EvalPro.model;

import lombok.Data;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "evaluaciones")
@Data
public class Evaluacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "alumno_id", nullable = false)
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "criterio_id", nullable = false)
    private Criterio criterio;

    @Column(nullable = false)
    private String estado; // Logrado, No Logrado, No Calificado

    @Column(nullable = false)
    private LocalDate fecha;
}