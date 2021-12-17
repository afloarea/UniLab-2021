package ro.unibuc.lab10.main.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ro.unibuc.lab10.main.dto.AddMovieRequest;
import ro.unibuc.lab10.main.dto.MovieEntry;
import ro.unibuc.lab10.main.model.Genre;
import ro.unibuc.lab10.main.model.Movie;
import ro.unibuc.lab10.main.repository.MovieRepository;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MovieServiceImplTest {

    @InjectMocks
    private MovieServiceImpl movieService;

    @Mock
    private MovieRepository movieRepo;

    @Test
    void testAddMovie() {
        // arrange
        final var request = new AddMovieRequest("title", Genre.ACTION, 8D);
        final var movie = new Movie();
        movie.setGenre(request.genre());
        movie.setTitle(request.title());
        movie.setRating(request.rating());
        movie.setId(1L);

        when(movieRepo.save(any())).thenReturn(movie);

        // act
        final var result = movieService.addMovie(request);

        // assert
        assertEquals(movie.getTitle(), result.title());
        assertEquals(movie.getId(), result.id());
        assertEquals(movie.getRating(), result.rating());
        assertSame(movie.getGenre(), result.genre());
    }

    private static final Map<String, Movie> MOVIES_STORE;
    static {
        final var m1 = new Movie();
        final var m2 = new Movie();
        m1.setId(1);
        m2.setId(2);
        m1.setTitle("Title1");
        m2.setTitle("Title2");
        m1.setRating(3D);
        m2.setRating(8D);
        m1.setGenre(Genre.ACTION);
        m2.setGenre(Genre.COMEDY);

        MOVIES_STORE = Stream.of(m1, m2).collect(Collectors.toUnmodifiableMap(Movie::getTitle, Function.identity()));
    }

    public static Stream<Arguments> findByTitleArgs() {
        return Stream.of(
                Arguments.of("Title1", new MovieEntry(1, "Title1", Genre.ACTION, 3D)),
                Arguments.of("Title2", new MovieEntry(2, "Title2", Genre.COMEDY, 8D)),
                Arguments.of("Title-1", null)
        );
    }

    @MethodSource("findByTitleArgs")
    @ParameterizedTest
    void testFindByTitle(String title, MovieEntry expected) {
        // arrange
        when(movieRepo.findByTitle(anyString())).thenAnswer(invocation -> Optional.ofNullable(MOVIES_STORE.get((String)invocation.getArguments()[0])));

        // act
        final var result = movieService.getByTitle(title);

        // assert
        verify(movieRepo, times(1)).findByTitle(title);
        if (expected == null) {
            assertTrue(result.isEmpty());
            return;
        }

        assertTrue(result.isPresent());
        assertEquals(expected, result.get());
    }

    @Test
    void testPassingRatingToRepoOnDelete() {
        // arrange
        ArgumentCaptor<Double> captor = ArgumentCaptor.forClass(Double.class);

        // act
        movieService.removeBadMovies(3D);

        // assert
        verify(movieRepo).deleteMoviesWithRatingBelow(captor.capture());

        assertEquals(3D, captor.getValue());
    }

}
