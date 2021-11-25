package ro.unibuc.lab07.classic.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import ro.unibuc.lab07.classic.model.Genre;
import ro.unibuc.lab07.classic.model.Play;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class PlaysRepositoryImpl implements PlaysRepository {

    private final String dbUrl;
    private final String user;
    private final String pass;

    public PlaysRepositoryImpl(@Value("${db.url}") String dbUrl,
                               @Value("${db.user}") String user,
                               @Value("${db.pass}") String pass) {
        this.dbUrl = dbUrl;
        this.user = user;
        this.pass = pass;
    }

    @Override
    public Play insert(Play play) {
        play.setId(UUID.randomUUID().toString());
        try (var conn = DriverManager.getConnection(dbUrl, user, pass);
             var statement = conn.prepareStatement("INSERT INTO plays VALUES (?, ?, ?, ?, ?)")) {
            statement.setString(1, play.getId());
            statement.setString(2, play.getTitle());
            statement.setString(3, play.getGenre().toString());
            statement.setString(4, play.getDuration().toString());
            statement.setString(5, play.getTheatreId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException("Failed to run SQL", e);
        }
        return play;
    }

    @Override
    public boolean delete(String id) {
        if (!exists(id)) {
            return false;
        }

        try (var conn = DriverManager.getConnection(dbUrl, user, pass);
             var statement = conn.prepareStatement("DELETE FROM plays WHERE id=?")) {
            statement.setString(1, id);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new IllegalStateException("Failed to run SQL", e);
        }
    }

    public boolean exists(String id) {
        try (var conn = DriverManager.getConnection(dbUrl, user, pass);
             var statement = conn.prepareStatement("SELECT id FROM plays WHERE id=?")) {
            statement.setString(1, id);

            final var rs = statement.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            throw new IllegalStateException("Failed to run SQL", e);
        }
    }

    @Override
    public List<Play> findAllForTheatreId(String theatreId) {
        try (var conn = DriverManager.getConnection(dbUrl, user, pass);
             var statement = conn.prepareStatement("SELECT * FROM plays WHERE theatre_id=?")) {
            statement.setString(1, theatreId);

            final var result = new ArrayList<Play>();
            final var rs = statement.executeQuery();
            while (rs.next()) {
                result.add(new Play(
                        rs.getString("id"),
                        rs.getString("title"),
                        Genre.valueOf(rs.getString("genre")),
                        Duration.parse(rs.getString("duration")),
                        rs.getString("theatre_id")));
            }

            return result;

        } catch (SQLException e) {
            throw new IllegalStateException("Failed to run SQL", e);
        }
    }
}
