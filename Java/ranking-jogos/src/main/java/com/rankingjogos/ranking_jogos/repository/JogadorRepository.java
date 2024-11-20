package com.rankingjogos.ranking_jogos.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rankingjogos.ranking_jogos.model.Jogador;

public interface JogadorRepository extends JpaRepository<Jogador, UUID>{

}
