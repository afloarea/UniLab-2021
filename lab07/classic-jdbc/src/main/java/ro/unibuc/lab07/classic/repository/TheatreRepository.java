package ro.unibuc.lab07.classic.repository;

import ro.unibuc.lab07.classic.model.Theatre;

import java.util.Optional;

public interface TheatreRepository {

    Theatre insert(Theatre theatre);

    Optional<Theatre> findById(String id);

    boolean exists(String id);

}
