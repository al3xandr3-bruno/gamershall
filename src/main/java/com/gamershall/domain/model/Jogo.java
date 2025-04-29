package com.gamershall.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Jogo {

    private Long id;
    private String nome;
    private String Genero;
    private Long nJogadores;
    private String dataLancamento;
    private String descricao;

    private Engine engine;
    private Estudio estudio;
}
