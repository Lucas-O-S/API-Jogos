using InterfaceRankingJogos.Models;
using System.Text.Json;
using System.Text.Json.Serialization;

namespace InterfaceRankingJogos.DAO
{
    public abstract class PadraoDAO <T> where T : PadraoViewModel
    {
        protected string apiURL { get; set; } = "http://localhost:8080/api/";

        protected abstract void DefinirURL();

        public PadraoDAO()
        {
            DefinirURL();
        }

        protected abstract void Post();
        protected abstract void Put();
        protected virtual async void Delete(Guid id) {
            string urlFInal = apiURL + id.ToString();
            HelperDAO.ChamarApi(urlFInal, "", HttpMethod.Delete).GetAwaiter().GetResult();
        }

        protected virtual List<T> GetAll()
        {
            List<T> list = JsonSerializer.Deserialize<List<T>>(HelperDAO.DevolverDadosApi(apiURL).GetAwaiter().GetResult());

            return list;
        }

        protected virtual T Get(Guid id)
        {
            string urlFInal = apiURL + id.ToString();
            T model = JsonSerializer.Deserialize<T>(HelperDAO.DevolverDadosApi(urlFInal).GetAwaiter().GetResult());

            return model;
        }


    }
}
