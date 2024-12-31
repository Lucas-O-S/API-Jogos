using InterfaceRankingJogos.DAO;
using InterfaceRankingJogos.Models;
using Microsoft.AspNetCore.Mvc;

namespace InterfaceRankingJogos.Controllers
{
    public class RankingController : Controller
    {
        private RankingDAO DAO = new RankingDAO();

        public IActionResult Index()
        {
            try
            {
                JogoDAO jogoDAO = new JogoDAO();
                ViewBag.jogos = jogoDAO.GetAll();
                return View("index");
            }
            catch (Exception ex)
            {
                return View("Error", new ErrorViewModel(ex.ToString()));

            }
        }


        public IActionResult PesquisaAvancada(Guid id)
        {
            try
            {
                List<RankingViewModel> lista = DAO.Get(id);

                return PartialView("pvIndex", lista);
            }
            catch (Exception ex)
            {
                return View("Error", new ErrorViewModel(ex.ToString()));

            }


        }
    }
}
