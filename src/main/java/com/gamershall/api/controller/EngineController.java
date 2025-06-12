package com.gamershall.api.controller;

import com.gamershall.domain.model.Engine;
import com.gamershall.domain.repository.EngineRepository;
import com.gamershall.domain.services.RegistroEngineService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/engines")
public class EngineController {

    private final EngineRepository engineRepository;
    private final RegistroEngineService registroEngineService;

    @GetMapping
    public List<Engine> listar(){
        return engineRepository.findAll();
    }

    @GetMapping("/{engineId}")
    public ResponseEntity<Engine> buscar(@PathVariable Long engineId) {
        return engineRepository.findById(engineId)
                .map(ResponseEntity::ok) //.map(jogo -> ResponseEntity.ok(jogo))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Engine adicionar(@Valid @RequestBody Engine engine){
        return registroEngineService.salvar(engine);
    }

    @DeleteMapping("/{engineId}")
    public ResponseEntity<Void> deletar(@PathVariable Long engineId){
        if(engineRepository.existsById(engineId)){
            registroEngineService.apagar(engineId);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{engineId}")
    public ResponseEntity atualizar(@Valid @PathVariable Long engineId, @RequestBody Engine engine){
        if(!engineRepository.existsById(engineId)){
            return ResponseEntity.notFound().build();
        }
        engine.setId(engineId);
        return ResponseEntity.ok(registroEngineService.salvar(engine));
    }
}
