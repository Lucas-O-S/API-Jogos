package com.rankingjogos.ranking_jogos.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rankingjogos.ranking_jogos.model.Jogador;

public interface JogadorRepository extends JpaRepository<Jogador, UUID>{
    Jogador save(Jogador jogador);
    Optional<Jogador> findById(UUID id);
    Jogador update(Jogador jogador, UUID id);
    List<Jogador> findAll();
    void deleteById(UUID id);
}
