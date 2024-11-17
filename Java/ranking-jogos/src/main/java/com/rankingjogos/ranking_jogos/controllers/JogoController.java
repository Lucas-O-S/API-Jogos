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

import com.rankingjogos.ranking_jogos.application.JogoService;
import com.rankingjogos.ranking_jogos.model.Jogo;



@RestController
@RequestMapping("/api/jogo")
public class JogoController {
    private final JogoService jogoService;

    public JogoController(JogoService jogoService){
        this.jogoService = jogoService;
    }

    @PostMapping
    public ResponseEntity<Jogo> CriarJogador(@RequestBody Jogo jogo) {
        
        return ResponseEntity.ok(jogoService.CriarJogo(jogo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jogo> AtualizarJogo(@PathVariable UUID id, @RequestBody Jogo jogo){
        return ResponseEntity.ok(jogoService.AtualizarJogo(id, jogo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jogo> ObterJogo(@PathVariable UUID id) {
        return jogoService.FindById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Jogo>> ListaJogos() {
        return ResponseEntity.ok(jogoService.FindAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Jogo> ExcluirJogo(@PathVariable UUID id){
        jogoService.Delete(id);
        return  ResponseEntity.noContent().build();
    }
    


    
    
}
