package com.evalpro.EvalPro.controller;

import com.evalpro.EvalPro.model.Criterio;
import com.evalpro.EvalPro.service.CriterioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/criterios")
@CrossOrigin(origins = "*")
public class CriterioController {

    @Autowired
    private CriterioService criterioService;

    @GetMapping
    public ResponseEntity<List<Criterio>> getAllCriterios() {
        return new ResponseEntity<>(criterioService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Criterio> getCriterioById(@PathVariable Long id) {
        return criterioService.findById(id)
                .map(criterio -> new ResponseEntity<>(criterio, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Criterio> createCriterio(@RequestBody Criterio criterio) {
        return new ResponseEntity<>(criterioService.save(criterio), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Criterio> updateCriterio(@PathVariable Long id, @RequestBody Criterio criterio) {
        return criterioService.findById(id)
                .map(existingCriterio -> {
                    criterio.setId(id);
                    return new ResponseEntity<>(criterioService.save(criterio), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCriterio(@PathVariable Long id) {
        return criterioService.findById(id)
                .map(criterio -> {
                    criterioService.deleteById(id);
                    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Criterio>> getCriteriosByUsuarioId(@PathVariable Long usuarioId) {
        List<Criterio> criterios = criterioService.findByUsuarioId(usuarioId);
        return new ResponseEntity<>(criterios, HttpStatus.OK);
    }
}