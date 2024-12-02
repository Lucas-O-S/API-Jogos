using InterfaceRankingJogos.DAO;
using InterfaceRankingJogos.Models;
using Microsoft.AspNetCore.Mvc;
using static System.Runtime.InteropServices.JavaScript.JSType;

namespace InterfaceRankingJogos.Controllers
{
    public abstract class PadraoController<T> : Controller where T : PadraoViewModel
    {
        protected PadraoDAO<T> dao { get; set; }
        public IActionResult Index()
        {
            try
            {
                var list = dao.GetAll();
                return View("index", list);
            }
            catch(Exception ex)
            {
                return View("Error", new ErrorViewModel(ex.ToString()));
            }

        }
    }
}
