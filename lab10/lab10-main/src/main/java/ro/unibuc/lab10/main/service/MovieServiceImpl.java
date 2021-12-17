package ro.unibuc.lab10.main.service;

import org.springframework.stereotype.Service;
import ro.unibuc.lab10.main.dto.AddMovieRequest;
import ro.unibuc.lab10.main.dto.MovieEntry;
import ro.unibuc.lab10.main.model.Movie;
import ro.unibuc.lab10.main.repository.MovieRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository repo;

    public MovieServiceImpl(MovieRepository repo) {
        this.repo = repo;
    }

    @Override
    public MovieEntry addMovie(AddMovieRequest request) {
        final var movie = new Movie();
        movie.setRating(request.rating());
        movie.setTitle(request.title());
        movie.setGenre(request.genre());

        final var saved = repo.save(movie);

        return mapToDto(saved);
    }

    @Override
    public List<MovieEntry> getAllMovies() {
        return repo.findAll().stream()
                .map(MovieServiceImpl::mapToDto)
                .toList();
    }

    @Override
    public List<MovieEntry> getTopMovies() {
        return repo.findTop3().stream()
                .map(MovieServiceImpl::mapToDto)
                .toList();
    }

    @Override
    public void removeBadMovies(double threshold) {
        repo.deleteMoviesWithRatingBelow(threshold);
    }

    @Override
    public Optional<MovieEntry> getByTitle(String title) {
        return repo.findByTitle(title).map(MovieServiceImpl::mapToDto);
    }

    private static MovieEntry mapToDto(Movie movie) {
        return new MovieEntry(movie.getId(), movie.getTitle(), movie.getGenre(), movie.getRating());
    }
}
