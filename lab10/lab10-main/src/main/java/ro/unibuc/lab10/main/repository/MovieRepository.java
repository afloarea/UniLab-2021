package ro.unibuc.lab10.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ro.unibuc.lab10.main.model.Movie;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM movies ORDER BY rating DESC LIMIT 3")
    List<Movie> findTop3();

    Optional<Movie> findByTitle(String title);

    @Transactional
    @Modifying
    @Query("DELETE FROM Movie m WHERE m.rating < :rating")
    void deleteMoviesWithRatingBelow(double rating);

}
