package com.rankingjogos.ranking_jogos.domain;
import java.util.List;
import java.util.UUID;

public interface PontuacaoRepository {
    Pontuacao Save(Pontuacao pontuacao);
    List<Pontuacao> FindByJogoId(UUID jogoId);
    List<Pontuacao> FindByJogadorId(UUID jogadorId);
}
