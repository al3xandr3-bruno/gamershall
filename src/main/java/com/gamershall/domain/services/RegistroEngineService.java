package com.gamershall.domain.services;

import com.gamershall.domain.exception.NegocioException;
import com.gamershall.domain.model.Engine;
import com.gamershall.domain.repository.EngineRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class RegistroEngineService {

    private final EngineRepository engineRepository;

    public Engine buscar(Long engineId){
        return engineRepository.findById(engineId)
                .orElseThrow(() -> new NegocioException("Engine inexistente!"));
    }

    @Transactional
    public void apagar(Long jogoId){
        engineRepository.deleteById(jogoId);
    }

    @Transactional
    public Engine salvar(Engine engine){
        return engineRepository.save(engine);
    }
}
