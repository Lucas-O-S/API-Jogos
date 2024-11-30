namespace InterfaceRankingJogos.Models
{
    public class PontuacaoViewModel: PadraoViewModel
    {
        public int pontos { get; set; }

        public JogadorViewModel jogador { get; set; }
        public JogoViewModel jogo { get; set; }

        public DateTime data_partida { get; set; }
    }
}
