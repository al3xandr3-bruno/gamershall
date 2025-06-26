package com.gamershall.domain.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Usuario{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String nome;
    private String nomeUsuario;
    private String email;
    private Long pontos;

    @OneToMany(mappedBy = "usuario")
    private List<JogoJogado> jogosJogados = new ArrayList<>();

    public JogoJogado adicionaJogo(JogoJogado jogoJogado){
        jogoJogado.setUsuario(this);
        return jogoJogado;
    }
}
