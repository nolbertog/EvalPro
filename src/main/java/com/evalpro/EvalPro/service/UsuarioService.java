package com.evalpro.EvalPro.service;

import com.evalpro.EvalPro.model.Usuario;
import java.util.List;
import java.util.Optional;

/**
 * Interface for Usuario service operations
 */
public interface UsuarioService {
    List<Usuario> findAll();
    Optional<Usuario> findById(Long id);
    Usuario save(Usuario usuario);
    void deleteById(Long id);
}