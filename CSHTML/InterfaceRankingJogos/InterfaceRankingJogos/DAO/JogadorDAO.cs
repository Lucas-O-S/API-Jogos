using InterfaceRankingJogos.Models;

namespace InterfaceRankingJogos.DAO
{
    public class JogadorDAO : PadraoDAO<JogadorViewModel>
    {
        public JogadorDAO() { }

        protected override void DefinirURL()
        {
            apiURL = apiURL + "jogadores";
        }
    }
}
