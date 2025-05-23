package com.evalpro.EvalPro.repository;

import com.evalpro.EvalPro.model.Criterio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CriterioRepository extends JpaRepository<Criterio, Long> {
    
    // Método personalizado para buscar criterios por ID de usuario
    List<Criterio> findByUsuarioId(Long usuarioId);
}