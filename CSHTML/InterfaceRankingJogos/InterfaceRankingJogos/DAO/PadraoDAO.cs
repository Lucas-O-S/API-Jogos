using InterfaceRankingJogos.Models;
using System.Reflection;
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

        public virtual void Post(T model) {
            string body = JsonSerializer.Serialize(model);
            HelperDAO.ChamarApi(apiURL, body, HttpMethod.Post).GetAwaiter().GetResult();

        }
        public virtual void Put(T model) {
            string urlFInal = apiURL + "/" + model.id;
            string body = JsonSerializer.Serialize(model);
            HelperDAO.ChamarApi(urlFInal, body, HttpMethod.Post).GetAwaiter().GetResult();
        }
        public virtual async void Delete(Guid id) {
            string urlFInal = apiURL + "/" + id.ToString();
            HelperDAO.ChamarApi(urlFInal, "", HttpMethod.Delete).GetAwaiter().GetResult();
        }

        public virtual List<T> GetAll()
        {
            List<T> list = JsonSerializer.Deserialize<List<T>>(HelperDAO.DevolverDadosApi(apiURL).GetAwaiter().GetResult());

            return list;
        }

        public virtual T Get(Guid id)
        {
            string urlFInal = apiURL + "/" + id.ToString();
            T model = JsonSerializer.Deserialize<T>(HelperDAO.DevolverDadosApi(urlFInal).GetAwaiter().GetResult());

            return model;
        }


    }
}
