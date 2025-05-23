package com.evalpro.EvalPro.model;

import lombok.Data;
import jakarta.persistence.*;

@Entity
@Table(name = "criterios")
@Data
public class Criterio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
}