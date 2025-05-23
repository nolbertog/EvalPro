package com.evalpro.EvalPro.controller;

import com.evalpro.EvalPro.model.Evaluacion;
import com.evalpro.EvalPro.service.EvaluacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evaluaciones")
@CrossOrigin(origins = "*")
public class EvaluacionController {

    @Autowired
    private EvaluacionService evaluacionService;

    @GetMapping
    public ResponseEntity<List<Evaluacion>> getAllEvaluaciones() {
        return new ResponseEntity<>(evaluacionService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evaluacion> getEvaluacionById(@PathVariable Long id) {
        return evaluacionService.findById(id)
                .map(evaluacion -> new ResponseEntity<>(evaluacion, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Evaluacion> createEvaluacion(@RequestBody Evaluacion evaluacion) {
        return new ResponseEntity<>(evaluacionService.save(evaluacion), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Evaluacion> updateEvaluacion(@PathVariable Long id, @RequestBody Evaluacion evaluacion) {
        return evaluacionService.findById(id)
                .map(evaluacionExistente -> {
                    evaluacion.setId(id);
                    return new ResponseEntity<>(evaluacionService.save(evaluacion), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvaluacion(@PathVariable Long id) {
        return evaluacionService.findById(id)
                .map(evaluacion -> {
                    evaluacionService.deleteById(id);
                    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/alumno/{alumnoId}")
    public ResponseEntity<List<Evaluacion>> getEvaluacionesByAlumnoId(@PathVariable Long alumnoId) {
        List<Evaluacion> evaluaciones = evaluacionService.findByAlumnoId(alumnoId);
        return new ResponseEntity<>(evaluaciones, HttpStatus.OK);
    }

    @GetMapping("/criterio/{criterioId}")
    public ResponseEntity<List<Evaluacion>> getEvaluacionesByCriterioId(@PathVariable Long criterioId) {
        List<Evaluacion> evaluaciones = evaluacionService.findByCriterioId(criterioId);
        return new ResponseEntity<>(evaluaciones, HttpStatus.OK);
    }
}