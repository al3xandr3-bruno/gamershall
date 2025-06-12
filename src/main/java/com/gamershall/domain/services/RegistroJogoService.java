package com.gamershall.domain.services;

import com.gamershall.domain.model.Engine;
import com.gamershall.domain.model.Estudio;
import com.gamershall.domain.model.Jogo;
import com.gamershall.domain.repository.JogoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@AllArgsConstructor
@Service
public class RegistroJogoService {

    private final JogoRepository jogoRepository;
    private final RegistroEngineService registroEngineService;
    private final RegistroEstudioService registroEstudioService;

    @Transactional
    public Jogo salvar(Jogo jogo){
        Engine engine = registroEngineService.buscar(jogo.getEngine().getId());
        Estudio estudio = registroEstudioService.buscar(jogo.getEstudio().getId());

        jogo.setEngine(engine);
        jogo.setEstudio(estudio);
        jogo.setDataLancamento(OffsetDateTime.now());

        return jogoRepository.save(jogo);
    }

    @Transactional
    public void excluir(Long jogoId){
        jogoRepository.deleteById(jogoId);
    }
}
