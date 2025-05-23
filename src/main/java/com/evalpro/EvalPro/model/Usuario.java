package com.evalpro.EvalPro.model;

import lombok.Data;
import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
@Data // Lombok para getters, setters, etc.
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password; // Recuerda hashear la contraseña
}