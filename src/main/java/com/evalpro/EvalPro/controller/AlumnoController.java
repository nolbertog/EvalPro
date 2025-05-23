package com.evalpro.EvalPro.controller;

import com.evalpro.EvalPro.model.Alumno;
import com.evalpro.EvalPro.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alumnos")
@CrossOrigin(origins = "*")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping
    public ResponseEntity<List<Alumno>> getAllAlumnos() {
        List<Alumno> alumnos = alumnoService.findAll();
        return new ResponseEntity<>(alumnos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alumno> getAlumnoById(@PathVariable Long id) {
        return alumnoService.findById(id)
                .map(alumno -> new ResponseEntity<>(alumno, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Alumno> createAlumno(@RequestBody Alumno alumno) {
        Alumno nuevoAlumno = alumnoService.save(alumno);
        return new ResponseEntity<>(nuevoAlumno, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alumno> updateAlumno(@PathVariable Long id, @RequestBody Alumno alumno) {
        return alumnoService.findById(id)
                .map(alumnoExistente -> {
                    alumno.setId(id);
                    Alumno alumnoActualizado = alumnoService.save(alumno);
                    return new ResponseEntity<>(alumnoActualizado, HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlumno(@PathVariable Long id) {
        return alumnoService.findById(id)
                .map(alumno -> {
                    alumnoService.deleteById(id);
                    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Alumno>> getAlumnosByUsuarioId(@PathVariable Long usuarioId) {
        List<Alumno> alumnos = alumnoService.findByUsuarioId(usuarioId);
        return new ResponseEntity<>(alumnos, HttpStatus.OK);
    }
}