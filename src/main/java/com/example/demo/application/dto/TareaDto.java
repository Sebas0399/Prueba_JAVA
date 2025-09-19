package com.example.demo.application.dto;

import com.example.demo.domain.entity.EstadoTarea;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class TareaDto {
    private String titulo;
    private String descripcion;
    private EstadoTarea estadoTarea;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
}
