package com.gamershall.domain.services;

import com.gamershall.domain.model.Jogo;
import com.gamershall.domain.repository.JogoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class RegistroJogoService {

    private final JogoRepository jogoRepository;

    @Transactional
    public Jogo salvar(Jogo jogo){
        return jogoRepository.save(jogo);
    }

    @Transactional
    public void excluir(Long jogoId){
        jogoRepository.deleteById(jogoId);
    }
}
