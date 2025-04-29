package com.gamershall.api.controller;

import com.gamershall.domain.model.Engine;
import com.gamershall.domain.model.Estudio;
import com.gamershall.domain.model.Jogo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class JogosController {

    @GetMapping("/jogos")
    public List<Jogo> listar(){

        var engine = new Engine();
        engine.setId(1L);
        engine.setNome("Irreal");
        engine.setVersao("1.23");
        engine.setEmpresaDesenvolvedora("Empresa fictícea horrível");

        var estudio1 = new Estudio();
        estudio1.setId(1l);
        estudio1.setNome("Bugsoft Montreal");
        estudio1.setEmpresaDona("Bugsoft Studios");

        var estudio2 = new Estudio();
        estudio2.setId(2l);
        estudio2.setNome("RockEstrela Japan");
        estudio2.setEmpresaDona("Rockestrela Studios");

        var jogo1 = new Jogo();
        jogo1.setId(1L);
        jogo1.setNome("Novo Começo: Horizonte");
        jogo1.setGenero("Ação e Aventura");
        jogo1.setNJogadores(1L);
        jogo1.setDataLancamento("16/05/2015");
        jogo1.setDescricao("Embarque numa aventura como uma menina ruiva misteriosa" +
                " e mate alguns robôs selvagens gigantes!");
        jogo1.setEngine(engine);
        jogo1.setEstudio(estudio1);

        var jogo2 = new Jogo();
        jogo2.setId(2L);
        jogo2.setNome("O Bom da Guerra");
        jogo2.setGenero("Ação e Aventura");
        jogo2.setNJogadores(1L);
        jogo2.setDataLancamento("16/05/2018");
        jogo2.setDescricao("Junte-se a Cratous numa história de vingança" +
                " contra os deuses que lhe tiraram tudo. " +
                "Uma histórioa cheia de reviravoltas e muita mitologia!");
        jogo2.setEngine(engine);
        jogo2.setEstudio(estudio2);


        return Arrays.asList(jogo1, jogo2);
    }

}
