package com.example.demo.infrastructure.controller;

import com.example.demo.application.dto.UsuarioDto;
import com.example.demo.application.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;
    @PostMapping("/register")
    public ResponseEntity<?> createUsuario(@Valid @RequestBody UsuarioDto usuarioDto) {

            UsuarioDto created = usuarioService.create(usuarioDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(created);

    }
}
