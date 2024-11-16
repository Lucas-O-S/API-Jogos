package com.rankingjogos.ranking_jogos.domain;
import java.util.List;
import java.util.UUID;

public interface PontuacaoRepository {
    Pontuacao save(Pontuacao pontuacao);
    List<Pontuacao> findByJogoId(UUID jogoId);
    List<Pontuacao> findByJogadorId(UUID jogadorId);
}
