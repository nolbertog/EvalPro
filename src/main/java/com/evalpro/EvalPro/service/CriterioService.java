package com.evalpro.EvalPro.service;

import com.evalpro.EvalPro.model.Criterio;
import java.util.List;
import java.util.Optional;

public interface CriterioService {
    List<Criterio> findAll();
    Optional<Criterio> findById(Long id);
    Criterio save(Criterio criterio);
    void deleteById(Long id);
    List<Criterio> findByUsuarioId(Long usuarioId);
}