package com.example.demo.application.dto;

import com.example.demo.domain.entity.Tarea;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
public class UsuarioDto {
    private Integer id;
    private String nombre;
    private String password;
    private String email;
    private List<Tarea> tareasLista;
}
