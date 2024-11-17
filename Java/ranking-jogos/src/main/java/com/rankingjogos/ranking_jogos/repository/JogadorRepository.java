package com.rankingjogos.ranking_jogos.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.rankingjogos.ranking_jogos.model.Jogador;

public interface JogadorRepository {
    Jogador Save(Jogador jogador);
    Jogador Update(UUID id, Jogador jogador);
    Optional<Jogador> FindById(UUID id);
    List<Jogador> FindAll();
    void Delete(UUID id);
}
