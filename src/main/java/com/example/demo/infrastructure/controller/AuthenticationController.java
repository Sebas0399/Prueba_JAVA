package com.example.demo.infrastructure.controller;

import com.example.demo.application.dto.AuthenticationRequest;
import com.example.demo.application.dto.AuthenticationResponse;
import com.example.demo.application.dto.UsuarioDto;
import com.example.demo.application.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest authRequest){
        AuthenticationResponse jwtDto=authenticationService.login(authRequest);
        return ResponseEntity.ok(jwtDto);
    }

}
