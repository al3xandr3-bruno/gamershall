package com.gamershall.api.model.input;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JogoInput {

    @NotBlank
    @Column(name = "titulo")
    private String nome;

    @NotBlank
    private String genero;

    @NotNull
    private Long nJogadores;

    @NotBlank
    private String sinopseDescricao;

    @Valid
    @NotNull
    private EngineIdInput engine;

    @Valid
    @NotNull
    private EstudioIdInput estudio;
}
