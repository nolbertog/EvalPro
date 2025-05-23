package com.evalpro.EvalPro.service;

import com.evalpro.EvalPro.model.Evaluacion;
import com.evalpro.EvalPro.repository.EvaluacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EvaluacionServiceImpl implements EvaluacionService {

    @Autowired
    private EvaluacionRepository evaluacionRepository;

    @Override
    public List<Evaluacion> findAll() {
        return evaluacionRepository.findAll();
    }

    @Override
    public Optional<Evaluacion> findById(Long id) {
        return evaluacionRepository.findById(id);
    }

    @Override
    public Evaluacion save(Evaluacion evaluacion) {
        return evaluacionRepository.save(evaluacion);
    }

    @Override
    public void deleteById(Long id) {
        evaluacionRepository.deleteById(id);
    }

    @Override
    public List<Evaluacion> findByAlumnoId(Long alumnoId) {
        return evaluacionRepository.findByAlumnoId(alumnoId);
    }

    @Override
    public List<Evaluacion> findByCriterioId(Long criterioId) {
        return evaluacionRepository.findByCriterioId(criterioId);
    }
}