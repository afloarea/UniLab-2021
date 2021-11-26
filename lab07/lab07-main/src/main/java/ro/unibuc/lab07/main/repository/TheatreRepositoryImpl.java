package ro.unibuc.lab07.main.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ro.unibuc.lab07.main.model.Theatre;

import java.util.Optional;
import java.util.UUID;

@Repository
public class TheatreRepositoryImpl implements TheatreRepository{

    private final JdbcTemplate jdbcTemplate;

    public TheatreRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Theatre insert(Theatre theatre) {
        theatre.setId(UUID.randomUUID().toString());

        jdbcTemplate.update("insert into theatres values (?, ?, ?)",
                theatre.getId(), theatre.getName(), theatre.getCity());

        return theatre;
    }

    @Override
    public boolean exists(String theatreId) {
        final var foundId = jdbcTemplate.queryForObject("select id from theatres where id = ?", String.class, theatreId);

        return foundId != null;
    }

    @Override
    public Optional<Theatre> read(String theatreId) {

        final var theatre = jdbcTemplate.queryForObject("select * from theatres where id = ?", (rs, rowNumber) -> {
            final var mapped = new Theatre();
            mapped.setId(rs.getString("id"));
            mapped.setName(rs.getString("name"));
            mapped.setCity(rs.getString("city"));

            return mapped;
        }, theatreId);

        return Optional.ofNullable(theatre);
    }
}
