package com.evalpro.EvalPro.service;

import com.evalpro.EvalPro.model.Usuario;
import java.util.Optional;

public interface LoginService {
    Optional<Usuario> login(String email, String password);
}