package com.rankingjogos.ranking_jogos.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rankingjogos.ranking_jogos.model.Jogo;

public interface JogoRepository extends JpaRepository<Jogo, UUID> {


}
