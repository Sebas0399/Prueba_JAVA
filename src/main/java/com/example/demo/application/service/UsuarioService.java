package com.example.demo.application.service;

import com.example.demo.application.dto.UsuarioDto;
import com.example.demo.domain.entity.Usuario;
import com.example.demo.domain.repository.IUsuarioRepository;
import com.example.demo.infrastructure.mapper.UsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private IUsuarioRepository usuarioRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    private UsuarioMapper usuarioMapper;
    public UsuarioDto create(UsuarioDto usuarioDto) {
        try {
            Usuario usuario = usuarioMapper.toEntity(usuarioDto);
            usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
            usuarioRepository.save(usuario);
            return usuarioMapper.toDTO(usuario);
        } catch (Exception e) {
            // Puedes lanzar RuntimeException o devolver un mensaje
            throw new RuntimeException("Error al crear el usuario: " + e.getMessage());
        }
    }
}
