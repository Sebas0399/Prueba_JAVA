package com.example.demo.application.dto;

import com.example.demo.domain.entity.EstadoTarea;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class TareaDto {
    @NotBlank(message = "Titulo no debe estar vacio")
    private String titulo;
    @NotBlank(message = "Descripcion no debe estar vacio")
    private String descripcion;
    @NotNull(message = "Estado no debe estar vacio")
    private EstadoTarea estadoTarea;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
}
