package com.gamershall.domain.model;

import com.gamershall.domain.validation.ValidationGroups;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.ConvertGroup;
import jakarta.validation.groups.Default;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @NotBlank
    @Column(name = "titulo")
    private String nome;

    @NotBlank
    private String genero;

    @NotNull
    private Long nJogadores;

    private OffsetDateTime dataLancamento;

    @NotBlank
    private String sinopseDescricao;

    @Valid
    @ConvertGroup(from = Default.class, to = ValidationGroups.EngineId.class)
    @NotNull
    @OneToOne
    private Engine engine;

    @Valid
    @ConvertGroup(from = Default.class, to = ValidationGroups.EstudioId.class)
    @NotNull
    @OneToOne
    private Estudio estudio;
}
