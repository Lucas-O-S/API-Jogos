from chalice import Chalice
from sqlalchemy import create_engine, select
from sqlalchemy.orm import sessionmaker
from models import Jogador, Pontuacao

# Configuração do Chalice
app = Chalice(app_name="ranking-jogos")

# Configuração do banco de dados
DATABASE_URL = "mssql+pyodbc://localhost:1433/api_jogos?driver=ODBC+Driver+17+for+SQL+Server&trusted_connection=yes"
engine = create_engine(DATABASE_URL)
SessionLocal = sessionmaker(autocommit=False, autoflush=False, bind=engine)

@app.route('api/ranking/{jogo_id}')
def obter_ranking(jogo_id):
    # Criação de uma sessão no banco de dados
    session = SessionLocal()

    try:
        # Consulta ao banco de dados
        query = (
            select(Jogador.nome, Pontuacao.pontos)
            .join(Pontuacao, Pontuacao.jogador_id == Jogador.id)  # Ajuste na condição de join
            .where(Pontuacao.jogo_id == jogo_id)
            .order_by(Pontuacao.pontos.desc())
            .limit(10)
        )
        
        # Executa a consulta e coleta o resultado
        resultado = session.execute(query).fetchall()  # Use fetchall() para obter todos os resultados

        # Formatação do resultado
        ranking = [{"nome": row[0], "pontos": row[1]} for row in resultado]  # Ajuste na forma de acessar os resultados
        return {"ranking": ranking}

    except Exception as e:
        app.log.error(f"Erro ao obter ranking: {e}")
        return {"error": "Erro ao consultar o banco de dados"}

    finally:
        # Fecha a sessão para evitar vazamentos
        session.close()
