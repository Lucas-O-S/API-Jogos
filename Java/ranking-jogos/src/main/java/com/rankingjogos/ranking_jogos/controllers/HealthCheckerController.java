package com.rankingjogos.ranking_jogos.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/health")
public class HealthCheckerController {

    @GetMapping
    public ResponseEntity checkHealth(){
        return  ResponseEntity.ok("Servidor em Funcionamento");
    }
}
