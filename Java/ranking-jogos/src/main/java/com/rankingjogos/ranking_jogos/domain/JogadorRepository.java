package com.rankingjogos.ranking_jogos.domain;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface JogadorRepository {
    Jogador Save(Jogador jogador);
    Optional<Jogador> FindById(UUID id);
    List<Jogador> FindAll();
    void Delete(UUID id);
}
