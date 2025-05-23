package com.evalpro.EvalPro.service;

import com.evalpro.EvalPro.model.Alumno;
import java.util.List;
import java.util.Optional;

public interface AlumnoService {
    List<Alumno> findAll();
    Optional<Alumno> findById(Long id);
    Alumno save(Alumno alumno);
    void deleteById(Long id);
    List<Alumno> findByUsuarioId(Long usuarioId);
}