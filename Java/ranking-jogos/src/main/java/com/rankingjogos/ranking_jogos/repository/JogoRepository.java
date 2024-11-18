package com.rankingjogos.ranking_jogos.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rankingjogos.ranking_jogos.model.Jogador;
import com.rankingjogos.ranking_jogos.model.Jogo;

public interface JogoRepository extends JpaRepository<Jogo, UUID> {
    Jogo save(Jogo jogo);
    Optional<Jogo> findById(UUID id);
    Jogador update(Jogador jogador, UUID id);
    List<Jogo> findAll();
    void deleteById(UUID id);

}
