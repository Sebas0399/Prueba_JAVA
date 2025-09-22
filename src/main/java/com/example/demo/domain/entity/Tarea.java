package com.example.demo.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Table
@Entity
@NoArgsConstructor

public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private String descripcion;
    private EstadoTarea estadoTarea;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
    @ManyToOne
    @JoinColumn(name = "usuario_id" ,nullable = false)
    private Usuario usuario;
}
