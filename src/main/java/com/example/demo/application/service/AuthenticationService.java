package com.example.demo.application.service;

import com.example.demo.application.dto.AuthenticationRequest;
import com.example.demo.application.dto.AuthenticationResponse;
import com.example.demo.application.dto.UsuarioDto;
import com.example.demo.domain.entity.Usuario;
import com.example.demo.domain.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class AuthenticationService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private IUsuarioRepository usuarioRepository;
    @Autowired
    private JwtService jwtService;

    public AuthenticationResponse login(AuthenticationRequest authenticationRequest){
        UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(
                authenticationRequest.getEmail(),authenticationRequest.getPassword()
        );
        authenticationManager.authenticate(authenticationToken);
        Usuario usuario=usuarioRepository.findByEmail(authenticationRequest.getEmail());
        String jwt=jwtService.generateToken(usuario,generateExtraClaims(usuario));
        return new AuthenticationResponse(jwt);

    }

    private Map<String,Object> generateExtraClaims(Usuario usuario) {
        Map<String,Object>extraClaims=new HashMap<>();
        extraClaims.put("nombre",usuario.getNombre());
        extraClaims.put("email",usuario.getEmail());
        return extraClaims;
    }
}
