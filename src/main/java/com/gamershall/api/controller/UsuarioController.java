package com.gamershall.api.controller;

import com.gamershall.api.mapper.UsuarioMapper;
import com.gamershall.api.model.UsuarioModel;
import com.gamershall.api.model.input.UsuarioInput;
import com.gamershall.domain.model.Jogo;
import com.gamershall.domain.model.JogoJogado;
import com.gamershall.domain.model.Usuario;
import com.gamershall.domain.repository.JogoJogadoRepository;
import com.gamershall.domain.repository.JogoRepository;
import com.gamershall.domain.repository.UsuarioRepository;
import com.gamershall.domain.services.RegistroUsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;
    private final RegistroUsuarioService registroUsuarioService;
    private final JogoJogadoRepository jogoJogadoRepository;
    private final UsuarioMapper usuarioMapper;

    @GetMapping
    public List<UsuarioModel> listar(){
        return usuarioMapper.toModelList(usuarioRepository.findAll());
    }

    @GetMapping("/{usuarioId}")
    public ResponseEntity<UsuarioModel> buscar(@PathVariable Long usuarioId){
        return usuarioRepository.findById(usuarioId)
                .map(usuarioMapper::toModel)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{usuarioId}/jogos")
    public List<Jogo> buscarJogos(@PathVariable Long usuarioId){
        return jogoJogadoRepository.findByUsuario(registroUsuarioService.buscar(usuarioId))
                .stream()
                .map(JogoJogado::getJogo)
                .toList();
    }

    @PostMapping("/{usuarioId}/jogos")
    public Jogo adicionarJogo(@RequestBody Jogo jogo, @PathVariable Long usuarioId){
        JogoJogado jogoJogado = new JogoJogado();
        jogoJogado.setJogo(jogo);
        return registroUsuarioService.buscar(usuarioId).adicionaJogo(jogoJogado).getJogo();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioModel adicionar(@RequestBody UsuarioInput usuarioInput){
        return usuarioMapper.toModel(registroUsuarioService.cadastrar(usuarioMapper.toEntity(usuarioInput)));
    }

    //preciso pensar em que atualizações um usuário pode fazer, até agora penso só no nome de usuário; talvez o email seja uma relevante também
    @PutMapping("/{usuarioId}")
    public ResponseEntity<UsuarioModel> atualizar(@RequestBody UsuarioInput usuarioInput, @PathVariable Long usuarioId){
        if(usuarioRepository.findById(usuarioId).isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Usuario usuarioAtualizado = usuarioMapper.toEntity(usuarioInput);
        usuarioAtualizado.setId(usuarioId);

        return ResponseEntity.ok(usuarioMapper.toModel(registroUsuarioService.cadastrar(usuarioAtualizado)));
    }
}
