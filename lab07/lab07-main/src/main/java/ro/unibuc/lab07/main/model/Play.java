package ro.unibuc.lab07.main.model;

import java.time.Duration;
import java.util.Objects;

public final class Play {

    private String id;
    private String title;
    private Genre genre;
    private Duration duration;
    private String theatreId;

    public Play() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Play)) return false;
        Play play = (Play) o;
        return Objects.equals(id, play.id) && Objects.equals(title, play.title) && genre == play.genre && Objects.equals(duration, play.duration) && Objects.equals(theatreId, play.theatreId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, genre, duration, theatreId);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public String getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(String theatreId) {
        this.theatreId = theatreId;
    }

    @Override
    public String toString() {
        return "Play{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", genre=" + genre +
                ", duration=" + duration +
                ", theatreId='" + theatreId + '\'' +
                '}';
    }
}
