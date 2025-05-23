package com.evalpro.EvalPro.service;

import com.evalpro.EvalPro.model.Evaluacion;
import java.util.List;
import java.util.Optional;

public interface EvaluacionService {
    List<Evaluacion> findAll();
    Optional<Evaluacion> findById(Long id);
    Evaluacion save(Evaluacion evaluacion);
    void deleteById(Long id);
    List<Evaluacion> findByAlumnoId(Long alumnoId);
    List<Evaluacion> findByCriterioId(Long criterioId);
}