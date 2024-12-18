using InterfaceRankingJogos.DAO;
using InterfaceRankingJogos.Models;
using Microsoft.AspNetCore.Mvc;

namespace InterfaceRankingJogos.Controllers
{
    public class JogadorController : PadraoController<JogadorViewModel>
    {
        public JogadorController() { dao = new JogadorDAO(); }
    }
}
