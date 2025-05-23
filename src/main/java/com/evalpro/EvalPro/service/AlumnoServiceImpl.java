package com.evalpro.EvalPro.service;

import com.evalpro.EvalPro.model.Alumno;
import com.evalpro.EvalPro.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Override
    public List<Alumno> findAll() {
        return alumnoRepository.findAll();
    }

    @Override
    public Optional<Alumno> findById(Long id) {
        return alumnoRepository.findById(id);
    }

    @Override
    public Alumno save(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    @Override
    public void deleteById(Long id) {
        alumnoRepository.deleteById(id);
    }

    @Override
    public List<Alumno> findByUsuarioId(Long usuarioId) {
        return alumnoRepository.findByUsuarioId(usuarioId);
    }
}