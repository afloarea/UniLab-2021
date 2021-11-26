package ro.unibuc.lab07.main.dto.theatres;

import ro.unibuc.lab07.main.dto.plays.PlayEntry;

import java.util.Collection;

public record ReadTheatreResponse(String name, String city, Collection<PlayEntry> plays) {
}
