namespace InterfaceRankingJogos.Models
{
    public class Pontuacao
    {
        public Guid id { get; set; }

        public int pontos { get; set; }

        public Jogador jogador { get; set; }
        public Jogo jogo { get; set; }

        public DateTime data_partida { get; set; }
    }
}
