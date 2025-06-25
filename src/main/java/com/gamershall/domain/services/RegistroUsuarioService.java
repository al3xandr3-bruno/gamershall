package com.gamershall.domain.services;

import com.gamershall.domain.exception.NegocioException;
import com.gamershall.domain.model.Usuario;
import com.gamershall.domain.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RegistroUsuarioService {

    private final UsuarioRepository usuarioRepository;

    public Usuario cadastrar(Usuario usuario){
        boolean nomeUsuarioEmUso = usuarioRepository.findByNomeUsuario(usuario.getNomeUsuario())
                .filter(u -> !u.equals(usuario))
                .isPresent();

        boolean emailEmUso = usuarioRepository.findByEmail(usuario.getEmail())
                .filter(u -> !u.equals(usuario))
                .isPresent();

        if(nomeUsuarioEmUso) throw new NegocioException("Esse nome de usuário está em uso!");
        if(emailEmUso) throw new NegocioException("Já existe um usuário cadastrado com esse email");

        return usuarioRepository.save(usuario);
    }
}
