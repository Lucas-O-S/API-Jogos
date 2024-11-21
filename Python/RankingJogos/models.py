from sqlalchemy import (
    Column, String, Integer, DateTime, ForeignKey, Text
)
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy.orm import relationship
from uuid import uuid4
import datetime

# Criação da base para as classes
Base = declarative_base()

class Jogador(Base):
    __tablename__ = 'Jogador'
    
    # Definindo as colunas
    id = Column(String(36), primary_key=True, default=str(uuid4()))
    nome = Column(String(255))
    email = Column(String(255))
    idade = Column(Integer)
    dataRegistro = Column(DateTime, default=datetime.datetime.utcnow)
    
    # Relacionamento com a tabela Pontuacao
    pontuacoes = relationship("Pontuacao", back_populates="jogador")

class Jogo(Base):
    __tablename__ = 'Jogo'
    
    # Definindo as colunas
    id = Column(String(36), primary_key=True, default=str(uuid4()))
    nome = Column(String(255))
    descricao = Column(Text)
    dataCriacao = Column(DateTime, default=datetime.datetime.utcnow)
    
    # Relacionamento com a tabela Pontuacao
    pontuacoes = relationship("Pontuacao", back_populates="jogo")

class Pontuacao(Base):
    __tablename__ = 'Pontuacao'
    
    # Definindo as colunas
    id = Column(String(36), primary_key=True, default=str(uuid4()))
    pontos = Column(Integer)
    data_Partida = Column(DateTime, default=datetime.datetime.utcnow)
    
    # Chaves estrangeiras
    jogador_id = Column(String(36), ForeignKey('Jogador.id'))
    jogo_id = Column(String(36), ForeignKey('Jogo.id'))
    
    # Relacionamentos com as tabelas Jogador e Jogo
    jogador = relationship("Jogador", back_populates="pontuacoes")
    jogo = relationship("Jogo", back_populates="pontuacoes")

