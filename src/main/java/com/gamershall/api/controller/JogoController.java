package com.gamershall.api.controller;

import com.gamershall.api.mapper.JogoMapper;
import com.gamershall.api.model.JogoModel;
import com.gamershall.domain.exception.NegocioException;
import com.gamershall.domain.model.Jogo;
import com.gamershall.domain.repository.JogoRepository;
import com.gamershall.domain.services.RegistroJogoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
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
    private final JogoMapper jogoMapper;

    @GetMapping
    public List<JogoModel> listar(){
        return jogoMapper.toModelList(jogoRepository.findAll());
    }

    @GetMapping("/{jogoId}")
    public ResponseEntity<JogoModel> buscar(@PathVariable Long jogoId) {
        return jogoRepository.findById(jogoId)
                .map(jogoMapper::toModel)
                .map(ResponseEntity::ok) //.map(jogo -> ResponseEntity.ok(jogo))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public JogoModel adicionar(@Valid @RequestBody Jogo jogo){
        return jogoMapper.toModel(jogoRepository.save(jogo));

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
    public ResponseEntity<JogoModel> atualizar(@Valid @PathVariable Long jogoId, @RequestBody Jogo jogo){
        if(!jogoRepository.existsById(jogoId)){
            return ResponseEntity.notFound().build();
        }
        jogo.setId(jogoId);
        return ResponseEntity.ok(jogoMapper.toModel(jogoRepository.save(jogo)));
    }
}
