using InterfaceRankingJogos.DAO;
using InterfaceRankingJogos.Models;
using Microsoft.AspNetCore.Mvc;

namespace InterfaceRankingJogos.Controllers
{
    public class JogadorController : PadraoController<JogadorViewModel>
    {
        public JogadorController() { dao = new JogadorDAO(); }
		protected override void ValidarDados(JogadorViewModel model, string operacao)
		{
			base.ValidarDados(model, operacao);

			if (String.IsNullOrEmpty(model.nome))
				ModelState.AddModelError("nome", "Valor vazio");
			
			if (String.IsNullOrEmpty(model.email))
				ModelState.AddModelError("email", "Valor vazio");
			
			if (model.idade <= 0)
				ModelState.AddModelError("idade", "Valor muito baixo");


		}

	}


}
