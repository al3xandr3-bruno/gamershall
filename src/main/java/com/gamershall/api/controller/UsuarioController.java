package com.gamershall.api.controller;

import com.gamershall.domain.model.Usuario;
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
