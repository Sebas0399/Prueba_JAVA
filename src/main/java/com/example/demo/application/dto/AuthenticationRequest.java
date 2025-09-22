package com.example.demo.application.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AuthenticationRequest {
    @NotBlank(message = "Email no debe estar vacio")
    private String email;
    @NotBlank(message = "Password no debe estar vacio")
    private String password;
}
