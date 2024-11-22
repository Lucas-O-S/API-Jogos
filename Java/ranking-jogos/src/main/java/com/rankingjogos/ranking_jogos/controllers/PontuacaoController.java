package com.rankingjogos.ranking_jogos.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rankingjogos.ranking_jogos.service.PontuacaoService;
import com.rankingjogos.ranking_jogos.model.Pontuacao;

@RestController
@RequestMapping("/api/pontucao")
public class PontuacaoController {
    private final PontuacaoService pontuacaoService;

    public PontuacaoController(PontuacaoService pontuacaoService){
        this.pontuacaoService = pontuacaoService; 
    }

    @PostMapping
    public ResponseEntity<Pontuacao> CriarPontuacao(@RequestBody Pontuacao pontuacao){
        return ResponseEntity.ok(pontuacaoService.Save(pontuacao));
    }

    @RequestMapping("/jogo/{id}")
    public ResponseEntity<List<Pontuacao>> BuscarPontuacaoJogo(@PathVariable UUID id){
        return ResponseEntity.ok(pontuacaoService.FindByJogoId(id));
    }

    @RequestMapping("/jogador/{id}")
    public ResponseEntity<List<Pontuacao>> BuscarPontuacaoJogador(@PathVariable UUID id){
        return ResponseEntity.ok(pontuacaoService.FindByJogadorId(id));
    }

}

