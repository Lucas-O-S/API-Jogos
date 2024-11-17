package com.rankingjogos.ranking_jogos.repository;
import java.util.List;
import java.util.UUID;

import com.rankingjogos.ranking_jogos.model.Pontuacao;

public interface PontuacaoRepository {
    Pontuacao Save(Pontuacao pontuacao);
    List<Pontuacao> FindByJogoId(UUID jogoId);
    List<Pontuacao> FindByJogadorId(UUID jogadorId);
    
}
