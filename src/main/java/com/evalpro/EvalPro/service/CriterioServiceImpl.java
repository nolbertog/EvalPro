package com.evalpro.EvalPro.service;

import com.evalpro.EvalPro.model.Criterio;
import com.evalpro.EvalPro.repository.CriterioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CriterioServiceImpl implements CriterioService {

    @Autowired
    private CriterioRepository criterioRepository;

    @Override
    public List<Criterio> findAll() {
        return criterioRepository.findAll();
    }

    @Override
    public Optional<Criterio> findById(Long id) {
        return criterioRepository.findById(id);
    }

    @Override
    public Criterio save(Criterio criterio) {
        return criterioRepository.save(criterio);
    }

    @Override
    public void deleteById(Long id) {
        criterioRepository.deleteById(id);
    }

    @Override
    public List<Criterio> findByUsuarioId(Long usuarioId) {
        return criterioRepository.findByUsuarioId(usuarioId);
    }
}