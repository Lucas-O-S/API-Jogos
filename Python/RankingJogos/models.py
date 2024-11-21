from sqlalchemy import Column, String, Integer, ForeignKey, Date, Table
from sqlalchemy.dialects.mysql import CHAR
from sqlalchemy.ext.declarative import declarative_base

Base = declarative_base()

class Jogador(Base):
    __tablename__ = "jogadores"
    id = Column(CHAR(36), primary_key=True)
    nome = Column(String(255), nullable=False)
    email = Column(String(255), nullable=False)
    idade = Column(Integer, nullable=False)


class Jogo(Base):
    __tablename__ = "jogos"
    id = Column(CHAR(36), primary_key=True)
    nome = Column(String(255), nullable=False)


class Pontuacao(Base):
    __tablename__ = "pontuacoes"
    id = Column(CHAR(36), primary_key=True)
    jogador_id = Column(CHAR(36), ForeignKey("jogadores.id"), nullable=False)
    jogo_id = Column(CHAR(36), ForeignKey("jogos.id"), nullable=False)
    pontos = Column(Integer, nullable=False)
    data_partida = Column(Date, nullable=False)
