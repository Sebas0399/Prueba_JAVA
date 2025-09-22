package com.example.demo.infrastructure.controller;

import com.example.demo.application.dto.TareaDto;
import com.example.demo.application.service.TareaService;
import com.example.demo.domain.entity.Usuario;
import jakarta.validation.Valid;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tareas")
public class TareaController {
    @Autowired
    private TareaService tareaService;

    // Crear tarea
    @PostMapping
    public ResponseEntity<?> createTarea(@Valid @RequestBody  TareaDto tareaDto) {

            TareaDto created = tareaService.create(tareaDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(created);

    }

    // Obtener todas las tareas de un usuario
    @GetMapping("/usuario/{userId}")
    public ResponseEntity<?> getTareasByUser(@PathVariable Integer userId) {
        try {
            List<TareaDto> tareas = tareaService.getTareasByUser(userId);
            return ResponseEntity.ok(tareas);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

    // Obtener una tarea específica
    @GetMapping("/{tareaId}")
    public ResponseEntity<?> getTarea(@PathVariable Integer tareaId) {
        try {
            TareaDto tarea = tareaService.getTarea(tareaId);
            return ResponseEntity.ok(tarea);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

    // Editar tarea
    @PutMapping("/{tareaId}")
    public ResponseEntity<?> editTarea(@Valid @RequestBody TareaDto tareaDto, @PathVariable Integer tareaId) {
        try {
            TareaDto updated = tareaService.edit(tareaDto, tareaId);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

    // Eliminar tarea
    @DeleteMapping("/{tareaId}")
    public ResponseEntity<?> deleteTarea(@PathVariable Integer tareaId) {
        try {
            Boolean deleted = tareaService.delete(tareaId);
            if (deleted) {
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("No se pudo eliminar la tarea");
            }
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }
}


