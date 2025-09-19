package com.example.demo.application.service;

import com.example.demo.application.dto.TareaDto;
import com.example.demo.application.service.util.UsuarioContext;
import com.example.demo.domain.entity.Tarea;
import com.example.demo.domain.entity.Usuario;
import com.example.demo.domain.repository.ITareaRepository;
import com.example.demo.domain.repository.IUsuarioRepository;
import com.example.demo.infrastructure.mapper.TareaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TareaService {
    @Autowired
    private ITareaRepository tareaRepository;
    @Autowired
    private TareaMapper tareaMapper;
    @Autowired
    private IUsuarioRepository usuarioRepository;
    @Autowired
    private UsuarioContext usuarioContext;
    public TareaDto create(TareaDto tareaDto){
        Tarea tarea=tareaMapper.toEntity(tareaDto);
        Usuario usuario=usuarioContext.getCurrentUsuario();
        tarea.setUsuario(usuario);
        tarea.setFechaCreacion(LocalDateTime.now());
        tarea.setFechaActualizacion(LocalDateTime.now());
        tarea=tareaRepository.save(tarea);
        return tareaMapper.toDTO(tarea);
    }
    public TareaDto getTarea(Integer id){
        Tarea tarea = tareaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarea no encontrada"));

        if(usuarioContext.usuarioAutorizado(tarea.getUsuario().getId())){
            throw new RuntimeException("Usuario no autorizado");
        }
        return tareaMapper.toDTO(tarea);
    }
    public TareaDto edit(TareaDto tareaDto,Integer id){
        Tarea tarea = tareaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarea no encontrada"));

        if(!usuarioContext.usuarioAutorizado(tarea.getUsuario().getId())){
            throw new RuntimeException("Usuario no autorizado");
        }
        tarea.setTitulo(tareaDto.getTitulo()!=null ?tareaDto.getTitulo():tarea.getTitulo());
        tarea.setDescripcion(tareaDto.getDescripcion()!=null?tareaDto.getDescripcion():tarea.getDescripcion());
        tarea.setEstadoTarea(tareaDto.getEstadoTarea()!=null?tareaDto.getEstadoTarea():tarea.getEstadoTarea());
        tarea.setFechaActualizacion(LocalDateTime.now());
        tarea = tareaRepository.save(tarea);
        return tareaMapper.toDTO(tarea);
    }
    public Boolean delete(Integer id){
        Tarea tarea = tareaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarea no encontrada"));

        if(!usuarioContext.usuarioAutorizado(tarea.getUsuario().getId())){
            throw new RuntimeException("Usuario no autorizado");
        }

        tareaRepository.delete(tarea);
        return true;
    }
    public List<TareaDto> getTareasByUser(Integer userId){
        if(usuarioContext.usuarioAutorizado(userId)){
            throw new RuntimeException("Usuario no autorizado");
        }
        return tareaMapper.toDto(tareaRepository.findByUsuarioId(userId));
    }

}
