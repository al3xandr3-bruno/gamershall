package com.gamershall.api.controller;

import com.gamershall.domain.model.Estudio;
import com.gamershall.domain.repository.EstudioRepository;
import com.gamershall.domain.services.RegistroEstudioService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/estudios")
public class EstudioController {
    private final EstudioRepository estudioRepository;
    private final RegistroEstudioService registroEstudioService;

    @GetMapping
    public List<Estudio> listar(){
        return estudioRepository.findAll();
    }

    @GetMapping("/{estudioId}")
    public ResponseEntity<Estudio> buscar(@PathVariable Long estudioId) {
        return estudioRepository.findById(estudioId)
                .map(ResponseEntity::ok) //.map(jogo -> ResponseEntity.ok(jogo))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Estudio adicionar(@Valid @RequestBody Estudio estudio){
        return registroEstudioService.salvar(estudio);
    }

    @DeleteMapping("/{estudioId}")
    public ResponseEntity<Void> deletar(@PathVariable Long estudioId){
        if(estudioRepository.existsById(estudioId)){
            registroEstudioService.excluir(estudioId);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{estudioId}")
    public ResponseEntity atualizar(@Valid @PathVariable Long estudioId, @RequestBody Estudio estudio){
        if(!estudioRepository.existsById(estudioId)){
            return ResponseEntity.notFound().build();
        }
        estudio.setId(estudioId);
        return ResponseEntity.ok(estudioRepository.save(estudio));
    }

}
