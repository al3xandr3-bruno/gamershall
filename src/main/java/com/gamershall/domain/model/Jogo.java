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

    @Column(name = "n_jogadores")
    private Long nJogadores;

    @Column(name = "data_de_lancamento")
    private String dataLancamento;

    @Column(name = "sinopse_descricao")
    private String descricao;

    @OneToOne //preciso de mais detalhes sobre isso
    @JoinColumn(name = "engine_id")
    private Engine engine;

    @OneToOne
    @JoinColumn(name = "estudio_id")
    private Estudio estudio;
}
