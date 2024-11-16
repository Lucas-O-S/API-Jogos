package com.rankingjogos.ranking_jogos.domain;
import java.sql.Date;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
@Entity
public class Pontuacao {

    @Id
    private UUID id;
    
    @ManyToOne
    private Jogador jogador;

    @ManyToOne
    private Jogo jogo;
    
    private int pontos;
    private Date dataPartida;

    // Construtor padrão
    public Pontuacao() {}

    // Construtor com parâmetros
    public Pontuacao(UUID id, Jogador jogador, Jogo jogo, int pontos, Date dataPartida) {
        this.id = id;
        this.jogador = jogador;
        this.jogo = jogo;
        this.pontos = pontos;
        this.dataPartida = dataPartida;
    }

    // Getters e Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public Date getDataPartida() {
        return dataPartida;
    }

    public void setDataPartida(Date dataPartida) {
        this.dataPartida = dataPartida;
    }
}
