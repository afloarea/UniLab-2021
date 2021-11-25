package ro.unibuc.lab07.classic.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import ro.unibuc.lab07.classic.model.Theatre;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;
import java.util.UUID;

@Repository
public class TheatreRepositoryImpl implements TheatreRepository {

    private final String dbUrl;
    private final String user;
    private final String pass;

    public TheatreRepositoryImpl(@Value("${db.url}") String dbUrl,
                               @Value("${db.user}") String user,
                               @Value("${db.pass}") String pass) {
        this.dbUrl = dbUrl;
        this.user = user;
        this.pass = pass;
    }

    @Override
    public Theatre insert(Theatre theatre) {
        theatre.setId(UUID.randomUUID().toString());
        try (var conn = DriverManager.getConnection(dbUrl, user, pass);
             var statement = conn.prepareStatement("INSERT INTO theatres VALUES (?, ?, ?)")) {
            statement.setString(1, theatre.getId());
            statement.setString(2, theatre.getName());
            statement.setString(3, theatre.getCity());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException("Failed to run SQL", e);
        }
        return theatre;
    }

    @Override
    public Optional<Theatre> findById(String id) {
        try (var conn = DriverManager.getConnection(dbUrl, user, pass);
             var statement = conn.prepareStatement("SELECT * FROM theatres WHERE id=?")) {
            statement.setString(1, id);

            final var rs = statement.executeQuery();
            if (rs.next()) {
                final var result = new Theatre();
                result.setId(rs.getString("id"));
                result.setName(rs.getString("name"));
                result.setCity(rs.getString("city"));
                return Optional.of(result);
            }

            return Optional.empty();

        } catch (SQLException e) {
            throw new IllegalStateException("Failed to run SQL", e);
        }
    }

    @Override
    public boolean exists(String id) {
        try (var conn = DriverManager.getConnection(dbUrl, user, pass);
             var statement = conn.prepareStatement("SELECT id FROM theatres WHERE id=?")) {
            statement.setString(1, id);

            final var rs = statement.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            throw new IllegalStateException("Failed to run SQL", e);
        }
    }
}
