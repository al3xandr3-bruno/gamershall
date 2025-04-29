package com.gamershall.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Engine {

    private Long id;
    private String nome;
    private String versao;
    private String empresaDesenvolvedora;
}
