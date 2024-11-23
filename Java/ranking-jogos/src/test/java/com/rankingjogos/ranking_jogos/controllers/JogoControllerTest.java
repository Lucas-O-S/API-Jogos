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
import com.rankingjogos.ranking_jogos.model.Jogo;
import com.rankingjogos.ranking_jogos.service.JogoService;

@WebMvcTest(JogoController.class)
public class JogoControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private JogoService jogoService;


    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void CriarJogoTeste() throws Exception{
        Jogo jogo = new Jogo();
        jogo.setId(UUID.randomUUID());
        jogo.setNome("Nome");
        jogo.setDescricao("Descrição");
        
        when(jogoService.CriarJogo(Mockito.any(Jogo.class))).thenReturn(jogo);

        String requestJson = objectMapper.writeValueAsString(jogo);
        
        mockMvc.perform(post("/api/jogo").contentType(MediaType.APPLICATION_JSON).content(requestJson)).andExpect(status().isOk()).andExpect(jsonPath("$.id").isNotEmpty()).andExpect(jsonPath("$.nome").value(jogo.getNome())).andExpect(jsonPath("$.descricao").value(jogo.getDescricao()));
    }

    @Test
    public void BuscaJogoTeste() throws Exception{
        UUID jogoId = UUID.fromString("123E4567-E89B-12A3-A456-416614174000");
        Jogo jogo = new Jogo();
        jogo.setId(jogoId);
        jogo.setNome("Nome");
        jogo.setDescricao("Descrição");

        when(jogoService.FindById(jogoId)).thenReturn(Optional.of(jogo));
        
        mockMvc.perform(get("/api/jogo/" + jogoId)).andExpect(status().isOk()).andExpect(jsonPath("$.id").isNotEmpty()).andExpect(jsonPath("$.nome").value(jogo.getNome())).andExpect(jsonPath("$.descricao").value(jogo.getDescricao()));
    }
}

