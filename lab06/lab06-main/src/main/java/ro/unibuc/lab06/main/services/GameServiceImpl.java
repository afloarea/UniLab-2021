package ro.unibuc.lab06.main.services;

import org.springframework.stereotype.Service;
import ro.unibuc.lab06.main.dto.AddGameResponse;
import ro.unibuc.lab06.main.dto.GameDto;
import ro.unibuc.lab06.main.exception.TooManyGamesException;
import ro.unibuc.lab06.main.model.Game;
import ro.unibuc.lab06.main.repositories.GameRepository;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class GameServiceImpl implements GameService {
    private static final Duration LIMITING_INTERVAL = Duration.ofMinutes(10);

    private final GameRepository gameRepo;

    public GameServiceImpl(GameRepository gameRepo) {
        this.gameRepo = gameRepo;
    }

    @Override
    public AddGameResponse addGame(GameDto game) {
        final var lastPublisherGame = gameRepo.findLastByPublisher(game.publisher());

        if (lastPublisherGame != null
                && LocalDateTime.now(ZoneOffset.UTC).minus(LIMITING_INTERVAL).
                isBefore(lastPublisherGame.registrationDateTime())) {

            throw new TooManyGamesException(game.publisher());
        }

        final var addedGame = gameRepo.add(mapToModel(game));
        return new AddGameResponse(addedGame.id());
    }

    @Override
    public GameDto getById(int id) {
        return mapToDto(gameRepo.findById(id));
    }

    private static Game mapToModel(GameDto dto) {
        return new Game(dto.title(), dto.price(), dto.publisher(), dto.genre());
    }

    private static GameDto mapToDto(Game model) {
        return new GameDto(model.title(), model.price(), model.publisher(), model.genre());
    }
}
