package com.gamershall.domain.services;

import com.gamershall.domain.model.Estudio;
import com.gamershall.domain.repository.EstudioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class RegistroEstudioService {

    private final EstudioRepository estudioRepository;

    @Transactional
    public Estudio salvar(Estudio estudio){
        return estudioRepository.save(estudio);
    }

    @Transactional
    public void excluir(Long estudioId){
        estudioRepository.deleteById(estudioId);
    }
}
