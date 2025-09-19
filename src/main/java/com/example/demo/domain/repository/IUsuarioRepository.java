package com.example.demo.domain.repository;

import com.example.demo.domain.entity.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
        Usuario findByEmail(String email);
}
