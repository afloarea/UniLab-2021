package ro.unibuc.lab10.main.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ro.unibuc.lab10.main.dto.AddMovieRequest;
import ro.unibuc.lab10.main.model.Genre;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class MovieServiceImplIntegrationTest {

    @Autowired
    private MovieService movieService;

    @Test
    void testAddAndGetByTitle() {
        // arrange
        final var request = new AddMovieRequest("title1", Genre.DRAMA, 3D);

        // act
        final var addResult = movieService.addMovie(request);
        final var found = movieService.getByTitle(request.title());

        // assert
        assertTrue(found.isPresent());
        assertEquals(addResult, found.get());
        assertEquals(found.get().title(), request.title());
    }

}
