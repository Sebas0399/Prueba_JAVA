package com.example.demo.infrastructure.mapper;

import com.example.demo.application.dto.UsuarioDto;
import com.example.demo.domain.entity.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UsuarioMapper {
    UsuarioDto toDTO(Usuario usuario);
    Usuario toEntity(UsuarioDto usuarioDto);
    List<UsuarioDto> toDto(List<Usuario> usuarioList);
    List<Usuario>toEntity(List<UsuarioDto> usuarioDtoList);
}
