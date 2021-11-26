package ro.unibuc.lab07.main.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ro.unibuc.lab07.main.model.Genre;
import ro.unibuc.lab07.main.model.Play;

import java.time.Duration;
import java.util.List;
import java.util.UUID;

@Repository
public class PlayRepositoryImpl implements PlayRepository {

    private final JdbcTemplate jdbcTemplate;

    public PlayRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Play insert(Play play) {
        play.setId(UUID.randomUUID().toString());

        jdbcTemplate.update("insert into plays values (?, ?, ?, ?, ?)",
                play.getId(), play.getTitle(), play.getGenre().toString(), play.getDuration().toString(), play.getTheatreId());

        return play;
    }

    @Override
    public void delete(String playId) {
        jdbcTemplate.update("delete from plays where id = ?", playId);
    }

    @Override
    public List<Play> findByTheatreId(String theatreId) {
        return jdbcTemplate.query("select * from plays where theatre_id = ?", (rs, rowNo) -> {
            final var mapped = new Play();
            mapped.setId(rs.getString("id"));
            mapped.setTitle(rs.getString("title"));
            mapped.setGenre(Genre.valueOf(rs.getString("genre")));
            mapped.setDuration(Duration.parse(rs.getString("duration")));
            mapped.setTheatreId(rs.getString("theatre_id"));

            return mapped;
        }, theatreId);
    }
}
