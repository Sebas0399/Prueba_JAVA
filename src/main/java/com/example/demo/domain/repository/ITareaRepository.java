package com.example.demo.domain.repository;

import com.example.demo.domain.entity.Tarea;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface ITareaRepository extends JpaRepository<Tarea, Integer> {
    List<Tarea> findByUsuarioId(Integer userId);
}
