package com.rankingjogos.ranking_jogos.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rankingjogos.ranking_jogos.application.JogadorService;
import com.rankingjogos.ranking_jogos.model.Jogador;

@RestController
@RequestMapping("/api/jogadores")
public class JogadorController {
    private final JogadorService jogadorService;

    public JogadorController(JogadorService jogadorService) {
        this.jogadorService = jogadorService;
    }

    @PostMapping
    public ResponseEntity<Jogador> CriarJogador(@RequestBody Jogador jogador) {
        return ResponseEntity.ok(jogadorService.CriarJogador(jogador));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jogador> AtualizarJogador(@PathVariable UUID id, @RequestBody Jogador jogador){
        return ResponseEntity.ok(jogadorService.AtualizarJogador(jogador, id));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Jogador> ObterJogador(@PathVariable UUID id) {
        return jogadorService.ObterJogador(id)
                             .map(ResponseEntity::ok)
                             .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Jogador>> ListarJogadores(){
        return ResponseEntity.ok(jogadorService.ListarJogadores());
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> RemoverJogador(@PathVariable UUID id) {
        jogadorService.RemoverJogador(id);
        return ResponseEntity.noContent().build();
    }
}


