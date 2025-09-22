package com.example.demo.application.dto;

import com.example.demo.domain.entity.Tarea;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class UsuarioDto {
    private Integer id;
    @NotBlank(message = "Nombre no puede estar vacio")
    private String nombre;
    @NotBlank(message = "Password no puede estar vacio")
    @Min(value = 8,message = "El password debe contener mas de 8 caracteres")
    private String password;
    @NotBlank(message = "Email no puede estar vacio")
    @Email(message = "Email no valido")
    private String email;
    private List<Tarea> tareasLista;
}
