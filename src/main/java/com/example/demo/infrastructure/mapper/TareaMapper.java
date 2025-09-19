package com.example.demo.infrastructure.mapper;

import com.example.demo.application.dto.TareaDto;
import com.example.demo.domain.entity.Tarea;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TareaMapper {
    TareaDto toDTO(Tarea tarea);
    Tarea toEntity(TareaDto tareaDto);
    List<TareaDto>toDto(List<Tarea> tareaList);
    List<Tarea>toEntity(List<TareaDto> tareaDtos);
}
