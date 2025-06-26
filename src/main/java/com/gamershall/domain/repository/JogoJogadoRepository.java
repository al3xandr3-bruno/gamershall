package com.gamershall.domain.repository;

import com.gamershall.domain.model.Jogo;
import com.gamershall.domain.model.JogoJogado;
import com.gamershall.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JogoJogadoRepository extends JpaRepository<JogoJogado, Long> {
    List<JogoJogado> findByUsuario(Usuario usuario);
}
