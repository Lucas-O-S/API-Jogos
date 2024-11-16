package com.rankingjogos.ranking_jogos.domain;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface JogoRepository {
    Jogador save(Jogador jogador);
    Optional<Jogador> findById(UUID id);
    List<Jogador> findAll();
    void delete(UUID id);
}
