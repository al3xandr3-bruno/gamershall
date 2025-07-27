package com.gamershall.domain.services;

import com.gamershall.domain.model.Jogo;
import com.gamershall.domain.model.JogoJogado;
import com.gamershall.domain.model.Usuario;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class RegistroJogoJogadoService {

    private final RegistroUsuarioService registroUsuarioService;

    @Transactional
    public JogoJogado registrar(Long usuarioId, JogoJogado jogoJogado){
        Usuario usuario = registroUsuarioService.buscar(usuarioId);

        return usuario.adicionaJogo(jogoJogado);
    }
}
