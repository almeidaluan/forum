package br.com.alura.forum.repository;

import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
}
