CREATE DATABASE api_jogos;

go
use api_jogos

CREATE TABLE Jogador (
    id CHAR(36) PRIMARY KEY,
    nome VARCHAR(255),
    email VARCHAR(255),
    idade INT,
    dataRegistro datetime DEFAULT getdate()
);
go
CREATE TABLE Jogo (
    id CHAR(36) PRIMARY KEY,
    nome VARCHAR(255),
    descricao TEXT,
    dataCriacao datetime DEFAULT getdate()
);
go
CREATE TABLE Pontuacao (
    id CHAR(36) PRIMARY KEY,
    jogadorId CHAR(36),
    jogoId CHAR(36),
    pontos INT,
    dataPartida datetime DEFAULT getdate(),
    FOREIGN KEY (jogadorId) REFERENCES Jogador(id),
    FOREIGN KEY (jogoId) REFERENCES Jogo(id)
);

