package ro.unibuc.lab10.main.service;

import ro.unibuc.lab10.main.dto.AddMovieRequest;
import ro.unibuc.lab10.main.dto.MovieEntry;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    MovieEntry addMovie(AddMovieRequest request);

    List<MovieEntry> getAllMovies();

    List<MovieEntry> getTopMovies();

    void removeBadMovies(double threshold);

    Optional<MovieEntry> getByTitle(String title);

}
