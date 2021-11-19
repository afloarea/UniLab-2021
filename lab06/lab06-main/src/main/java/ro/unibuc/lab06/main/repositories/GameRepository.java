package ro.unibuc.lab06.main.repositories;

import ro.unibuc.lab06.main.model.Game;

public interface GameRepository {

    Game add(Game game);

    Game findById(int id);

    Game findLastByPublisher(String publisher);

}
