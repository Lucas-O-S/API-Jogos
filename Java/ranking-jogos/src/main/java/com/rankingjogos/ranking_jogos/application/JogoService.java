package com.rankingjogos.ranking_jogos.application;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.rankingjogos.ranking_jogos.model.Jogo;
import com.rankingjogos.ranking_jogos.repository.JogoRepository;

@Service
public class JogoService {
    private final JogoRepository jogoRepository;

    public JogoService(JogoRepository jogoRepository){
        this.jogoRepository = jogoRepository;
    }

    public Jogo CriarJogo(Jogo jogo){
        return jogoRepository.save(jogo);
    }

    public Jogo AtualizarJogo(Jogo jogo, UUID id){
        jogo.setId(id);
        return jogoRepository.save(jogo);
    }

    public Optional<Jogo> FindById(UUID id){
        return jogoRepository.findById(id);
    } 

    public List<Jogo> FindAll(){
        return jogoRepository.findAll();
    }

    public void Delete(UUID id){
        jogoRepository.deleteById(id);
    }

}
