using System;
using System.Text;

namespace InterfaceRankingJogos.DAO
{
    public static class HelperDAO
    {
        public static async Task ChamarApi(string url, string body, HttpMethod method)
        {
            using (HttpClient client = new HttpClient())
            {
                HttpContent content = string.IsNullOrEmpty(body) ? null : new StringContent(body, Encoding.UTF8, "application/json");

                HttpRequestMessage response = new HttpRequestMessage(method, url)
                {
                    Content = content
                };

                HttpResponseMessage responseMessage = await client.SendAsync(response);

                responseMessage.EnsureSuccessStatusCode();
            }
        }
        public static async Task<string?> DevolverDadosApi(string url)
        {
            using (HttpClient client = new HttpClient())
            {
                HttpResponseMessage responseMessage = await client.GetAsync(url);

                responseMessage.EnsureSuccessStatusCode();

                return await responseMessage.Content.ReadAsStringAsync();
            }
        }

        public static async Task<bool> ServerChecker()
        {
            try
            {
                using (HttpClient client = new HttpClient())
                {

                    HttpResponseMessage responseMessage = await client.GetAsync("http://localhost:8080/api/health");

                    return responseMessage.IsSuccessStatusCode;
                }
            }
            catch
            {
                return false;
            }

        }
    }
}
