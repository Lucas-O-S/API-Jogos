from fastapi import FastAPI
from sqlalchemy import create_engine, select
from sqlalchemy.orm import sessionmaker
from models import Jogador, Jogo, Pontuacao

app = FastAPI()
DATABASE_URL = "mssql+pyodbc://SA:123456@localhost:1433/api_jogos?driver=ODBC+Driver+17+for+SQL+Server&encrypt=false&trustServerCertificate=true"
engine = create_engine(DATABASE_URL)
SessionLocal = sessionmaker(autocommit=False, autoflush=False, bind=engine)

@app.get("/ranking/{jogo_id}")
def obter_ranking(jogo_id: str):
    session = SessionLocal()
    query = (
        select(Jogador.nome, Pontuacao.pontos)
        .join(Pontuacao, Jogador.id == Pontuacao.jogador_id)
        .where(Pontuacao.jogo_id == jogo_id)
        .order_by(Pontuacao.pontos.desc())
        .limit(10)
    )
    resultado = session.execute(query).all()
    session.close()
    return {"ranking": [{"nome": row.nome, "pontos": row.pontos} for row in resultado]}
