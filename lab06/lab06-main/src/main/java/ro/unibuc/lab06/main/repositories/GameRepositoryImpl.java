package ro.unibuc.lab06.main.repositories;

import org.springframework.stereotype.Repository;
import ro.unibuc.lab06.main.model.Game;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

@Repository
public class GameRepositoryImpl implements GameRepository {

    private final Map<Integer, Game> internalStorage = new HashMap<>();

    @Override
    public Game add(Game game) {
        final var id = internalStorage.size() + 1;
        internalStorage.put(id, new Game(id, game.title(), game.price(), game.publisher(), game.genre()));
        return internalStorage.get(id);
    }

    @Override
    public Game findById(int id) {
        return internalStorage.get(id);
    }

    @Override
    public Game findLastByPublisher(String publisher) {
        return internalStorage.values().stream()
                .filter(game -> game.publisher().equals(publisher))
                .sorted(Comparator.comparing(Game::registrationDateTime).reversed())
                .findFirst()
                .orElse(null);
    }
}
