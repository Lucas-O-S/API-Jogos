using InterfaceRankingJogos.Models;
using Microsoft.AspNetCore.Mvc;

namespace InterfaceRankingJogos.Controllers
{
    public abstract class PadraoController <T> : Controller where T : PadraoViewModel
    {
        public IActionResult Index()
        {
            return View();
        }
    }
}
