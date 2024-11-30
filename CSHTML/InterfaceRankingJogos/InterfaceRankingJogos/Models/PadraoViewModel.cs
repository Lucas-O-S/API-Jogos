namespace InterfaceRankingJogos.Models
{
    public abstract class PadraoViewModel
    {
        public PadraoViewModel() { 
            Id = Guid.NewGuid();
        }
        public Guid Id { get;}
    }
}
