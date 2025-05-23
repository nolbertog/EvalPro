package com.evalpro.EvalPro.controller;

import com.evalpro.EvalPro.model.Usuario;
import com.evalpro.EvalPro.service.LoginService;
import com.evalpro.EvalPro.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/login")
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public ResponseEntity<LoginResponse> login(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        String password = credentials.get("password");

        if (email == null || password == null || email.isEmpty() || password.isEmpty()) {
            return new ResponseEntity<>(new LoginResponse("Email y contraseña son obligatorios", null, null), HttpStatus.BAD_REQUEST);
        }

        Optional<Usuario> usuarioOpt = loginService.login(email, password);
        if (usuarioOpt.isPresent()) {
            String token = JwtUtil.generateToken(email);
            Usuario usuario = usuarioOpt.get();
            return new ResponseEntity<>(new LoginResponse("Login exitoso", usuario.getId(), token), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new LoginResponse("Credenciales inválidas", null, null), HttpStatus.UNAUTHORIZED);
        }
    }

    public static class LoginResponse {
        private String message;
        private Long usuarioId;
        private String token;

        public LoginResponse(String message, Long usuarioId, String token) {
            this.message = message;
            this.usuarioId = usuarioId;
            this.token = token;
        }

        public String getMessage() {
            return message;
        }

        public Long getUsuarioId() {
            return usuarioId;
        }

        public String getToken() {
            return token;
        }
    }
}