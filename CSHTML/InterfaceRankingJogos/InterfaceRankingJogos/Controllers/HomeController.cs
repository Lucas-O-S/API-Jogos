using InterfaceRankingJogos.Models;
using Microsoft.AspNetCore.Mvc;
using System.Diagnostics;

namespace InterfaceRankingJogos.Controllers
{
    public class HomeController : Controller
    {
        private readonly ILogger<HomeController> _logger;

        public HomeController(ILogger<HomeController> logger)
        {
            _logger = logger;
        }

        public IActionResult Index()
        {
            return View();
        }

        public IActionResult Privacy()
        {
            return View();
        }

        [HttpGet("Error")]

        [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
        public IActionResult Error()
        {
            return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
        }

        [HttpGet("Error/{erro?}")]
        public IActionResult Error(string erro)
        {
            return View("Error", new ErrorViewModel(erro));
        }

       
    }
}
