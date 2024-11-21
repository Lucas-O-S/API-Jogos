CREATE DATABASE api_jogos;

go
use api_jogos

CREATE TABLE Jogador (
    id UNIQUEIDENTIFIER PRIMARY KEY,
    nome VARCHAR(255),
    email VARCHAR(255),
    idade INT,
    dataRegistro datetime DEFAULT getdate()
);
go
CREATE TABLE Jogo (
    id UNIQUEIDENTIFIER  PRIMARY KEY,
    nome VARCHAR(255),
    descricao TEXT,
    dataCriacao datetime DEFAULT getdate()
);
go
CREATE TABLE Pontuacao (
    id UNIQUEIDENTIFIER PRIMARY KEY,
    jogador_Id UNIQUEIDENTIFIER,
    jogo_Id UNIQUEIDENTIFIER,
    pontos INT,
    data_Partida datetime DEFAULT getdate(),
    FOREIGN KEY (jogador_Id) REFERENCES Jogador(id),
    FOREIGN KEY (jogo_Id) REFERENCES Jogo(id)
);
