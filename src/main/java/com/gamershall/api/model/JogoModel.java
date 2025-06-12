package com.gamershall.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JogoModel {

    private Long id;
    private String nome;
    private String genero;
    private Long nJogadores;
    private String dataLancamento;
    private String sinopseDescricao;
    private EngineResumoModel engine;
    private EstudioResumoModel estudio;
}
