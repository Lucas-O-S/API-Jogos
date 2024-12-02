using InterfaceRankingJogos.Models;

namespace InterfaceRankingJogos.DAO
{
    public class JogoDAO: PadraoDAO<JogoViewModel>
    {
        protected override void DefinirURL()
        {
            apiURL = apiURL + "jogo";
        }




    }
}
