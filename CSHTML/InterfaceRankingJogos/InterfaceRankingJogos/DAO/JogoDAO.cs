﻿using InterfaceRankingJogos.Models;

namespace InterfaceRankingJogos.DAO
{
    public class JogoDAO: PadraoDAO<JogoViewModel>
    {
        public JogoDAO() { }

        protected override void DefinirURL()
        {
            apiURL = apiURL + "jogo";
        }






    }
}
