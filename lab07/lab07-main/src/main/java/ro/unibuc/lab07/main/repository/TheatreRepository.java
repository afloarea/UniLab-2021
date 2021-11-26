package ro.unibuc.lab07.main.repository;

import ro.unibuc.lab07.main.model.Theatre;

import java.util.Optional;

public interface TheatreRepository {

    Theatre insert(Theatre theatre);

    boolean exists(String theatreId);

    Optional<Theatre> read(String theatreId);

}
