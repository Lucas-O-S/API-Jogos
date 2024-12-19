using InterfaceRankingJogos.Models;
using System.Text.Json;

namespace InterfaceRankingJogos.DAO
{
    public class PontuacaoDAO : PadraoDAO<PontuacaoViewModel>
    {
        string apiRanking = "http://localhost:8000/api/ranking/";

        protected override void DefinirURL()
        {
            apiURL += "pontuacao";
        }

        public List<PontuacaoViewModel> BuscarRanking(Guid idJogo)
        {
            string UrlFinal = apiRanking + "/" + idJogo;
            List<PontuacaoViewModel> model = JsonSerializer.Deserialize<List<PontuacaoViewModel>>(HelperDAO.DevolverDadosApi(UrlFinal).GetAwaiter().GetResult()); ;

            return model;
        }

        public List<PontuacaoViewModel> GetAll(Guid id, string opcao)
        {
			string UrlFinal = apiURL + "/" + opcao + "/" + id;
			List<PontuacaoViewModel> model = JsonSerializer.Deserialize<List<PontuacaoViewModel>>(HelperDAO.DevolverDadosApi(UrlFinal).GetAwaiter().GetResult()); ;
            return model;

		}


	}
}
