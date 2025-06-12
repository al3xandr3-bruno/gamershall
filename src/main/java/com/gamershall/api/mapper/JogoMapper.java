package com.gamershall.api.mapper;

import com.gamershall.api.model.JogoModel;
import com.gamershall.api.model.input.JogoInput;
import com.gamershall.domain.model.Jogo;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class JogoMapper {

    private final ModelMapper modelMapper;

    public JogoModel toModel(Jogo jogo){
        return modelMapper.map(jogo, JogoModel.class);
    }

    public List<JogoModel> toModelList(List<Jogo> jogos){
        return jogos.stream()
                .map(jogo -> modelMapper.map(jogo, JogoModel.class))
                .toList();
    }

    public Jogo toEntity(JogoInput jogoInput){
        return modelMapper.map(jogoInput, Jogo.class);
    }
}
