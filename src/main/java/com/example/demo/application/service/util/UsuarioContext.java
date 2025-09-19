package com.example.demo.application.service.util;

import com.example.demo.domain.entity.Usuario;
import com.example.demo.domain.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class UsuarioContext {
    @Autowired
    private IUsuarioRepository usuarioRepository;
    public Usuario getCurrentUsuario() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        return usuarioRepository.findByEmail(email);
    }
    public boolean usuarioAutorizado(Integer userId){
        return  this.getCurrentUsuario().getId().equals(userId);
    }
}
