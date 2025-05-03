package com.gamershall.api.controller;

import com.gamershall.domain.model.Estudio;
import com.gamershall.domain.model.Jogo;
import com.gamershall.domain.repository.JogoRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@AllArgsConstructor
public class JogosController {

    private final JogoRepository jogoRepository;

    @GetMapping("/jogos")
    public List<Jogo> listar(){
        return jogoRepository.findAll();
    }

}
