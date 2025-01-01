using InterfaceRankingJogos.DAO;
using InterfaceRankingJogos.Models;
using Microsoft.AspNetCore.Mvc;

namespace InterfaceRankingJogos.Controllers
{
    public class JogoController : PadraoController<JogoViewModel>
    {
        public JogoController() { dao = new JogoDAO();}

		protected override void ValidarDados(JogoViewModel model, string operacao)
		{
			base.ValidarDados(model, operacao);

			if (String.IsNullOrEmpty(model.nome))
			{
				ModelState.AddModelError("nome", "Valor vazio");
			}
			if (String.IsNullOrEmpty(model.descricao))
			{
				ModelState.AddModelError("descricao", "Valor vazio");
			}

		}
	}

    
}
