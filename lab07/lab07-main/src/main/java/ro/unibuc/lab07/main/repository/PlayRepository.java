package ro.unibuc.lab07.main.repository;

import ro.unibuc.lab07.main.model.Play;

import java.util.List;

public interface PlayRepository {

    Play insert(Play play);

    void delete(String playId);

    List<Play> findByTheatreId(String theatreId);

}
