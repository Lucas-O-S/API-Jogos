using InterfaceRankingJogos.DAO;
using InterfaceRankingJogos.Models;
using Microsoft.AspNetCore.Mvc;

namespace InterfaceRankingJogos.Controllers
{
    public class PontuacaoController : PadraoController<PontuacaoViewModel>
    {
        public PontuacaoController() { dao = new PontuacaoDAO();  }

        public override IActionResult Index()
        {
            try
            {
                ViewBags();

                return View("Index");
            }
            catch (Exception ex)
            {
                return View("Error", new ErrorViewModel(ex.ToString()));
            }
        }


		protected override void ViewBags()
		{
			JogoDAO jogoDao = new JogoDAO();
			ViewBag.jogos = jogoDao.GetAll();

			JogadorDAO jogadorDao = new JogadorDAO();
			ViewBag.jogadores = jogadorDao.GetAll();
		}

		public IActionResult Ranking(Guid jogoId)
        {
            try
            {
                PontuacaoDAO pDao = new PontuacaoDAO();
                List<PontuacaoViewModel> lista = pDao.BuscarRanking(jogoId);


                return View("",lista);
            }
            catch (Exception ex)
            {
                return View("Error", new ErrorViewModel(ex.ToString()));

            }
        }

        public IActionResult PesquisaAvancada(Guid id, string opcao)
        {
            try
            {
				string escolha;
				if (opcao == "0")
					escolha = "jogo";
				else
					escolha = "jogador";

				PontuacaoDAO pDao = new PontuacaoDAO();

				List<PontuacaoViewModel> lista = pDao.GetAll(id, escolha);

				return PartialView("pvIndex", lista);
			}
            catch(Exception ex)
            {
				return View("Error", new ErrorViewModel(ex.ToString()));

			}


		}

		public IActionResult PesquisaAvancada(Guid id)
		{
			try
			{


				PontuacaoDAO pDao = new PontuacaoDAO();

				List<PontuacaoViewModel> lista = pDao.BuscarRanking(id);

				return PartialView("pvIndex", lista);
			}
			catch (Exception ex)
			{
				return View("Error", new ErrorViewModel(ex.ToString()));

			}


		}
	}
}
