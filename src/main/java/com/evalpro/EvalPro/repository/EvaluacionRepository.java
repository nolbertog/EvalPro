package com.evalpro.EvalPro.repository;

import com.evalpro.EvalPro.model.Evaluacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvaluacionRepository extends JpaRepository<Evaluacion, Long> {
    
    // Find evaluaciones by alumno ID
    List<Evaluacion> findByAlumnoId(Long alumnoId);
    
    // Find evaluaciones by criterio ID
    List<Evaluacion> findByCriterioId(Long criterioId);
}