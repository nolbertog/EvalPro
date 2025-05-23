package com.evalpro.EvalPro.repository;

import com.evalpro.EvalPro.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
    
    // Método personalizado para buscar alumnos por ID de usuario
    List<Alumno> findByUsuarioId(Long usuarioId);
}