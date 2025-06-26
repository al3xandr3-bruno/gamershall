package com.gamershall.api.controller;

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

    @GetMapping
    public List<Usuario> listar(){
        return usuarioRepository.findAll();
    }

    @GetMapping("/{usuarioId}")
    public ResponseEntity<Usuario> buscar(@PathVariable Long usuarioId){
        return usuarioRepository.findById(usuarioId)
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
    public Usuario adicionar(@RequestBody Usuario usuario){
        return registroUsuarioService.cadastrar(usuario);
    }

    @PutMapping("/{usuarioId}")
    public ResponseEntity<Usuario> atualizar(@RequestBody Usuario usuario, @PathVariable Long usuarioId){
        if(usuarioRepository.findById(usuarioId).isEmpty()){
            return ResponseEntity.notFound().build();
        }
        usuario.setId(usuarioId);
        return ResponseEntity.ok(registroUsuarioService.cadastrar(usuario));
    }
}
