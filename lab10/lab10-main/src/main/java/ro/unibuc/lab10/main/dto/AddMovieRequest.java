package ro.unibuc.lab10.main.dto;

import ro.unibuc.lab10.main.model.Genre;

public record AddMovieRequest(String title, Genre genre, double rating) {
}
