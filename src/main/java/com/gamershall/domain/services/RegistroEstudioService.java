package com.gamershall.domain.services;

import com.gamershall.domain.exception.NegocioException;
import com.gamershall.domain.model.Estudio;
import com.gamershall.domain.repository.EstudioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class RegistroEstudioService {

    private final EstudioRepository estudioRepository;

    public Estudio buscar(Long estudioId){
        return estudioRepository.findById(estudioId)
                .orElseThrow(() -> new NegocioException("Estudio inexsitente!"));
    }

    @Transactional
    public Estudio salvar(Estudio estudio){
        return estudioRepository.save(estudio);
    }

    @Transactional
    public void excluir(Long estudioId){
        estudioRepository.deleteById(estudioId);
    }
}
