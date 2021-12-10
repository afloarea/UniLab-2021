package ro.unibuc.lab09.main.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.unibuc.lab09.main.dto.AddMovieRequest;
import ro.unibuc.lab09.main.dto.MovieEntry;
import ro.unibuc.lab09.main.service.MovieService;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public MovieEntry addMovie(@RequestBody AddMovieRequest request) {
        return movieService.addMovie(request);
    }

    @GetMapping
    public List<MovieEntry> listMovies(@RequestParam(value = "top", defaultValue = "false") boolean top) {
        return top ? movieService.getTopMovies() : movieService.getAllMovies();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping
    public void removeBadMovies(@RequestParam(value = "ratingThreshold") double threshold) {
        movieService.removeBadMovies(threshold);
    }

    @GetMapping("/{title}")
    public ResponseEntity<MovieEntry> getByTitle(@PathVariable("title") String title) {
        return ResponseEntity.of(movieService.getByTitle(title));
    }
}
