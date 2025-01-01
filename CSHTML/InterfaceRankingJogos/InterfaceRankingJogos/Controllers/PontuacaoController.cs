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

        protected override void ValidarDados(PontuacaoViewModel model, string operacao)
        {
            base.ValidarDados(model, operacao);

            if (model.pontos < 0)
                ModelState.AddModelError("pontos", "Pontuação invalida");


            if (model.dataPartida < new DateTime(1753, 01, 01))
                ModelState.AddModelError("data_partida","Data invalida, escolha uma maior");
            if (model.dataPartida > DateTime.Today)
                ModelState.AddModelError("data_partida", "Data invalida, escolha uma menor");
            

        }

    }
}
