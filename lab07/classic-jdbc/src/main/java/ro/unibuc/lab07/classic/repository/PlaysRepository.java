package ro.unibuc.lab07.classic.repository;

import ro.unibuc.lab07.classic.model.Play;

import java.util.List;

public interface PlaysRepository {

    Play insert(Play play);

    boolean delete(String id);

    List<Play> findAllForTheatreId(String theatreId);

}
