import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface JogoRepository {
    Jogo save(Jogo jogo);
    Optional<Jogo> findById(UUID id);
    List<Jogo> findAll();
    void delete(UUID id);
}
