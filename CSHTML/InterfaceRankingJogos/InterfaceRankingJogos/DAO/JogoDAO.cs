using InterfaceRankingJogos.Models;

namespace InterfaceRankingJogos.DAO
{
    public class JogoDAO: PadraoDAO<JogoViewModel>
    {
        protected override void DefinirURL()
        {
            apiURL = apiURL = "/jogo";
        }

        protected override void Post()
        {
            throw new NotImplementedException();
        }
        protected override void Put()
        {
            throw new NotImplementedException();
        }
    }
}
