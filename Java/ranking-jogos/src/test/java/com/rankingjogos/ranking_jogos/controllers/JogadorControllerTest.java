package com.rankingjogos.ranking_jogos.controllers;

import java.util.Optional;
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
import com.rankingjogos.ranking_jogos.service.JogadorService;

@WebMvcTest(JogadorController.class)
public class JogadorControllerTest {

    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private JogadorService jogadorService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void CriarJogadorTeste() throws Exception{
        Jogador jogador = new Jogador();
        jogador.setId(UUID.randomUUID());
        jogador.setNome("nome");
        jogador.setEmail("email");
        jogador.setIdade(20);

        when(jogadorService.CriarJogador(Mockito.any(Jogador.class))).thenReturn(jogador);

        String requestJson = objectMapper.writeValueAsString(jogador);

        mockMvc.perform(post("/api/jogadores").contentType(MediaType.APPLICATION_JSON).content(requestJson)).andExpect(status().isOk()).andExpect(jsonPath("$.id").isNotEmpty()).andExpect(jsonPath("$.nome").value(jogador.getNome())).andExpect(jsonPath("$.email").value(jogador.getEmail())).andExpect(jsonPath("$.idade").value(jogador.getIdade()));

    }
    @Test
    public void BuscarJogadorTeste() throws Exception{
        Jogador jogador = new Jogador();
        jogador.setId(UUID.fromString("123E4567-E89B-12A3-A456-426614174000"));
        jogador.setNome("nome");
        jogador.setEmail("email");
        jogador.setIdade(20);

        when(jogadorService.ObterJogador(jogador.getId())).thenReturn(Optional.of(jogador));

        mockMvc.perform(get("/api/jogadores/"+ String.valueOf(jogador.getId()))).andExpect(status().isOk()).andExpect(jsonPath("$.id").isNotEmpty()).andExpect(jsonPath("$.nome").value(jogador.getNome())).andExpect(jsonPath("$.email").value(jogador.getEmail())).andExpect(jsonPath("$.idade").value(jogador.getIdade()));

    }

}
