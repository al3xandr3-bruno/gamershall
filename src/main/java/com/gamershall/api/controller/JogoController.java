package com.gamershall.api.controller;

import com.gamershall.domain.exception.NegocioException;
import com.gamershall.domain.model.Jogo;
import com.gamershall.domain.repository.JogoRepository;
import com.gamershall.domain.services.RegistroJogoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/jogos")
public class JogoController {

    private final JogoRepository jogoRepository;
    private final RegistroJogoService registroJogoService;

    @GetMapping
    public List<Jogo> listar(){
        return jogoRepository.findAll();
    }

    @GetMapping("/{jogoId}")
    public ResponseEntity<Jogo> buscar(@PathVariable Long jogoId) {
        return jogoRepository.findById(jogoId)
                .map(ResponseEntity::ok) //.map(jogo -> ResponseEntity.ok(jogo))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Jogo adicionar(@RequestBody Jogo jogo){
        return registroJogoService.salvar(jogo);
    }

    @DeleteMapping("/{jogoId}")
    public ResponseEntity<Void> deletar(@PathVariable Long jogoId){
        if (!jogoRepository.existsById(jogoId)){
            return ResponseEntity.notFound().build();
        }
        registroJogoService.excluir(jogoId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{jogoId}")
    public ResponseEntity atualizar(@PathVariable Long jogoId, @RequestBody Jogo jogo){
        if(!jogoRepository.existsById(jogoId)){
            return ResponseEntity.notFound().build();
        }
        jogo.setId(jogoId);
        return ResponseEntity.ok(jogoRepository.save(jogo));
    }

    @ExceptionHandler(NegocioException.class)
    public ResponseEntity<String> captura(NegocioException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}
