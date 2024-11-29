package com.rankingjogos.ranking_jogos.controllers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rankingjogos.ranking_jogos.model.Jogador;
import com.rankingjogos.ranking_jogos.model.Jogo;
import com.rankingjogos.ranking_jogos.model.Pontuacao;
import com.rankingjogos.ranking_jogos.service.PontuacaoService;

@WebMvcTest(PontuacaoController.class)
public class PontuacaoControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PontuacaoService pontuacaoService;


    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void CriarPontuacaoTeste() throws Exception{
        Pontuacao pontuacao = new Pontuacao();
        pontuacao.setId(UUID.randomUUID());

        Jogador jogador = new Jogador();
        jogador.setId(UUID.fromString("123E4567-E89B-12A3-A456-426614174000"));
        pontuacao.setJogador(jogador);

        Jogo jogo = new Jogo();
        jogo.setId(UUID.fromString("123E4567-E89B-12A3-A456-416614174000"));
        pontuacao.setJogo(jogo);

        pontuacao.setPontos(10);
        pontuacao.setDataPartida(Date.valueOf("2003-10-20"));
        
        when(pontuacaoService.Save(Mockito.any(Pontuacao.class))).thenReturn(pontuacao);

        String requestJson = objectMapper.writeValueAsString(pontuacao);
        
        mockMvc.perform(post("/api/pontuacao").contentType(MediaType.APPLICATION_JSON).content(requestJson)).andExpect(status().isOk()).andExpect(jsonPath("$.id").isNotEmpty());
    }

    @Test
    public void BuscaJogoTeste() throws Exception{
        UUID jogoId = UUID.fromString("123E4567-E89B-12A3-A456-416614174000");
       List<Pontuacao> pontuacoes = new ArrayList<>();


        when(pontuacaoService.FindByJogoId(jogoId)).thenReturn(pontuacoes);
        
        mockMvc.perform(get("/api/pontuacao/jogo/" + jogoId)).andExpect(status().isOk());
    }

    @Test
    public void BuscaJogadoresTeste() throws Exception{
       UUID jogadorId = UUID.fromString("123E4567-E89B-12A3-A456-416614174000");
       List<Pontuacao> pontuacoes = new ArrayList<>();


        when(pontuacaoService.FindByJogoId(jogadorId)).thenReturn(pontuacoes);
        
        mockMvc.perform(get("/api/pontuacao/jogador/" + jogadorId)).andExpect(status().isOk());
    }
}

