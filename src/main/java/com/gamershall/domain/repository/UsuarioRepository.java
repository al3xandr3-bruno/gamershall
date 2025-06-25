package com.gamershall.domain.repository;

import com.gamershall.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByNomeUsuario(String nomeUsuario);

    Optional<Usuario> findByEmail(String email);
}
