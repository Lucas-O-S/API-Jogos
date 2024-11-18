package com.rankingjogos.ranking_jogos.application;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.rankingjogos.ranking_jogos.model.Pontuacao;
import com.rankingjogos.ranking_jogos.repository.PontuacaoRepository;

@Service
public class PontuacaoService {
    private final PontuacaoRepository pontuacaoRepository;

    public PontuacaoService(PontuacaoRepository pontuacaoRepository) {
        this.pontuacaoRepository = pontuacaoRepository;
    }

    public Pontuacao Save(Pontuacao pontuacao){
        return pontuacaoRepository.save(pontuacao);
    }

    public List<Pontuacao> FindByJogoId(UUID jogoId){
        return pontuacaoRepository.FindByJogadorId(jogoId);
    }

    public List<Pontuacao> FindByJogadorId(UUID jogadorId){
        return pontuacaoRepository.FindByJogadorId(jogadorId);
    }
    
}
