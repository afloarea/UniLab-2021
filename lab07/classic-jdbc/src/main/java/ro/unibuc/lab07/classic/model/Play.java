package ro.unibuc.lab07.classic.model;

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

    public Play(String id, String title, Genre genre, Duration duration, String theatreId) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.theatreId = theatreId;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Play)) return false;
        Play play = (Play) o;
        return Objects.equals(id, play.id) && Objects.equals(title, play.title)
                && genre == play.genre && Objects.equals(duration, play.duration)
                && Objects.equals(theatreId, play.theatreId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, genre, duration, theatreId);
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
