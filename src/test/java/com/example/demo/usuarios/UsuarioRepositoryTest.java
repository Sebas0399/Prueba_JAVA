package com.example.demo.usuarios;
import static org.junit.jupiter.api.Assertions.*;
import com.example.demo.domain.entity.Usuario;
import com.example.demo.domain.repository.IUsuarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
@DataJpaTest
public class UsuarioRepositoryTest {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Test
    void testEmailUnico() {
        Usuario user1 = new Usuario();
        user1.setEmail("test@example.com");
        user1.setNombre("user1");
        user1.setPassword("123456");
        usuarioRepository.save(user1);

        Usuario user2 = new Usuario();
        user2.setEmail("test@example.com");
        user2.setNombre("user2");
        user2.setPassword("abcdef");

        assertThrows(DataIntegrityViolationException.class, () -> {
            usuarioRepository.saveAndFlush(user2); //
        });
    }
}

