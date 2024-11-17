package com.rankingjogos.ranking_jogos.application;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.rankingjogos.ranking_jogos.model.Jogo;
import com.rankingjogos.ranking_jogos.repository.JogoRepository;

public class JogoService {
    private final JogoRepository jogoRepository;

    public JogoService(JogoRepository jogoRepository){
        this.jogoRepository = jogoRepository;
    }

    public Jogo AtualizarJogo(UUID id, Jogo jogo){
        return jogoRepository.Update(id, jogo);
    }

    public Jogo CriarJogo(Jogo jogo){
        return jogoRepository.Save(jogo);
    }

    public Optional<Jogo> FindById(UUID id){
        return jogoRepository.FindById(id);
    } 

    public List<Jogo> FindAll(){
        return jogoRepository.FindAll();
    }

    public void Delete(UUID id){
        jogoRepository.Delete(id);
    }

}
