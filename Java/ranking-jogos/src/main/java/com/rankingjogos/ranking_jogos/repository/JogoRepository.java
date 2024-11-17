package com.rankingjogos.ranking_jogos.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.rankingjogos.ranking_jogos.model.Jogo;

public interface JogoRepository {
    Jogo Save(Jogo jogo);
    Jogo Update(UUID id, Jogo jogo);
    Optional<Jogo> FindById(UUID id);
    List<Jogo> FindAll();
    void Delete(UUID id);

}
