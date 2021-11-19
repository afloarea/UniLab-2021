package ro.unibuc.lab06.main.services;

import ro.unibuc.lab06.main.dto.AddGameResponse;
import ro.unibuc.lab06.main.dto.GameDto;

public interface GameService {

    AddGameResponse addGame(GameDto game);

    GameDto getById(int id);

}
