package com.rankingjogos.ranking_jogos.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.rankingjogos.ranking_jogos.model.Jogador;
import com.rankingjogos.ranking_jogos.repository.JogadorRepository;

@Service
public class JogadorService {

    private final JogadorRepository jogadorRepository;

    public JogadorService(JogadorRepository jogadorRepository) {
        this.jogadorRepository = jogadorRepository;
    }

    public Jogador CriarJogador(Jogador jogador) {
        return jogadorRepository.save(jogador);
    }

    public Jogador AtualizarJogador(Jogador jogador, UUID id){
        jogador.setId(id);
        return jogadorRepository.save(jogador);
    }

    public Optional<Jogador> ObterJogador(UUID id) {
        return jogadorRepository.findById(id);
    }

    public List<Jogador> ListarJogadores() {
        return jogadorRepository.findAll();
    }

    public void RemoverJogador(UUID id) {
        jogadorRepository.deleteById(id);
    }
}
