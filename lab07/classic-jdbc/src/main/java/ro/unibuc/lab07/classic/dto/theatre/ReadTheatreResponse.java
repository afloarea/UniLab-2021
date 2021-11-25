package ro.unibuc.lab07.classic.dto.theatre;

import ro.unibuc.lab07.classic.dto.play.PlayEntry;

import java.util.Collection;

public record ReadTheatreResponse(String name, String city, Collection<PlayEntry> plays) {
}
