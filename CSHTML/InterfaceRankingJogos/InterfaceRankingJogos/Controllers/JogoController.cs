using InterfaceRankingJogos.DAO;
using InterfaceRankingJogos.Models;
using Microsoft.AspNetCore.Mvc;

namespace InterfaceRankingJogos.Controllers
{
    public class JogoController : PadraoController<JogoViewModel>
    {
        public JogoController() { dao = new JogoDAO();}

    }
}
