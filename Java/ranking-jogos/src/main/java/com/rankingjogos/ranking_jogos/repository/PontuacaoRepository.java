package com.rankingjogos.ranking_jogos.repository;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rankingjogos.ranking_jogos.model.Pontuacao;

public interface PontuacaoRepository extends JpaRepository<Pontuacao, UUID>{
    List<Pontuacao> findByJogo_Id(UUID jogoId);
    List<Pontuacao> findByJogador_Id(UUID jogadorId); 
    
}
