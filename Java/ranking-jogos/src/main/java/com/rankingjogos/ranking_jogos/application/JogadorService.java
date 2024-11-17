package com.rankingjogos.ranking_jogos.application;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.rankingjogos.ranking_jogos.model.Jogador;
import com.rankingjogos.ranking_jogos.repository.JogadorRepository;

public class JogadorService {

    private final JogadorRepository jogadorRepository;

    public JogadorService(JogadorRepository jogadorRepository) {
        this.jogadorRepository = jogadorRepository;
    }

    public Jogador CriarJogador(Jogador jogador) {
        return jogadorRepository.Save(jogador);
    }

    public Jogador AtualizarJogador(UUID id, Jogador jogador) {
        return jogadorRepository.Update(id, jogador);
    }

    public Optional<Jogador> ObterJogador(UUID id) {
        return jogadorRepository.FindById(id);
    }

    public List<Jogador> ListarJogadores() {
        return jogadorRepository.FindAll();
    }

    public void RemoverJogador(UUID id) {
        jogadorRepository.Delete(id);
    }
}
