package com.gamershall.domain.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "titulo")
    private String nome;
    private String genero;
    private Long nJogadores;
    private String dataLancamento;
    private String sinopseDescricao;

    @OneToOne
    private Engine engine;

    @OneToOne
    private Estudio estudio;
}
