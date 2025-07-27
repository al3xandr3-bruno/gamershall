package com.gamershall.api.controller;

import com.gamershall.api.mapper.JogoMapper;
import com.gamershall.api.model.JogoModel;
import com.gamershall.api.model.input.JogoInput;
import com.gamershall.domain.model.JogoJogado;
import com.gamershall.domain.repository.JogoJogadoRepository;
import com.gamershall.domain.services.RegistroUsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/usuarios/{usuarioId}/jogos")
public class JogoJogadoController {

    private final JogoJogadoRepository jogoJogadoRepository;
    private final RegistroUsuarioService registroUsuarioService;
    private final JogoMapper jogoMapper;

    @GetMapping
    public List<JogoModel> buscarJogos(@PathVariable Long usuarioId){
        return jogoJogadoRepository.findByUsuario(registroUsuarioService.buscar(usuarioId))
                .stream()
                .map(JogoJogado::getJogo)
                .map(jogoMapper::toModel)
                .toList();
    }

    @PostMapping
    public JogoModel adicionarJogo(@RequestBody JogoInput jogoInput, @PathVariable Long usuarioId){
        JogoJogado jogoJogado = new JogoJogado();
        jogoJogado.setJogo(jogoMapper.toEntity(jogoInput));
        return jogoMapper.toModel(registroUsuarioService.buscar(usuarioId).adicionaJogo(jogoJogado).getJogo());
    }
}
