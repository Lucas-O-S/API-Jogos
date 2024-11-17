package com.rankingjogos.ranking_jogos.application;

import java.util.List;
import java.util.UUID;

import com.rankingjogos.ranking_jogos.model.Pontuacao;
import com.rankingjogos.ranking_jogos.repository.PontuacaoRepository;

public class PontuacaoService {
    private final PontuacaoRepository pontuacaoRepository;

    public PontuacaoService(PontuacaoRepository pontuacaoRepository) {
        this.pontuacaoRepository = pontuacaoRepository;
    }

    public Pontuacao Save(Pontuacao pontuacao){
        return pontuacaoRepository.Save(pontuacao);
    }

    public List<Pontuacao> FindByJogoId(UUID jogoId){
        return pontuacaoRepository.FindByJogadorId(jogoId);
    }

    public List<Pontuacao> FindByJogadorId(UUID jogadorId){
        return pontuacaoRepository.FindByJogadorId(jogadorId);
    }
    
}
