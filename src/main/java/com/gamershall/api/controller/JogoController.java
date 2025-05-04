package com.gamershall.api.controller;

import com.gamershall.domain.model.Jogo;
import com.gamershall.domain.repository.JogoRepository;
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
        return jogoRepository.save(jogo);
    }

    @DeleteMapping("/{jogoId}")
    public ResponseEntity<Void> deletar(@PathVariable Long jogoId){
        if(jogoRepository.existsById(jogoId)){
            jogoRepository.deleteById(jogoId);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{jogoId}")
    public ResponseEntity atualizar(@PathVariable Long jogoId, @RequestBody Jogo jogo){
        if(!jogoRepository.existsById(jogoId)){
            return ResponseEntity.notFound().build();
        }
        jogo.setId(jogoId);
        return ResponseEntity.ok(jogoRepository.save(jogo));
    }

}
