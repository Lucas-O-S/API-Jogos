using Microsoft.AspNetCore.Mvc;

namespace InterfaceRankingJogos.Controllers
{
    public class JogoController : PadraoController
    {
        public IActionResult Index()
        {
            return View();
        }
    }
}
