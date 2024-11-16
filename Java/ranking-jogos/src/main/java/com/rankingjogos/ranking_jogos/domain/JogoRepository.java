package com.rankingjogos.ranking_jogos.domain;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface JogoRepository {
    Jogo Save(Jogo jogo);
    Optional<Jogo> FindById(UUID id);
    List<Jogo> FindAll();
    void Delete(UUID id);
}
