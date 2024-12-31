using InterfaceRankingJogos.Models;
using System.Text.Json;

namespace InterfaceRankingJogos.DAO
{
    public class RankingDAO
    {
        string apiURL { get; set; } = "http://localhost:8000/api/ranking/";


        public virtual List<RankingViewModel> Get(Guid id)
        {
            string urlFInal = apiURL + id.ToString();
            var result = HelperDAO.DevolverDadosApi(urlFInal).GetAwaiter().GetResult();
            
            using(JsonDocument doc = JsonDocument.Parse(result))
            {
                var rankArrary = doc.RootElement.GetProperty("ranking").EnumerateArray();

                List<RankingViewModel> model = rankArrary.Select(value => new RankingViewModel
                {
                    nome = value.GetProperty("nome").GetString(),
                    pontos = value.GetProperty("pontos").GetInt32()

                }).ToList();
                return model;

            }

        }
    }


}
