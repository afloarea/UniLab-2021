package ro.unibuc.lab06.main.dto;

import ro.unibuc.lab06.main.model.Genre;

import javax.validation.constraints.*;

public record GameDto(@NotBlank @Size(max = 10) String title,
                      @DecimalMax("29.99") @Positive @Digits(integer = 2, fraction = 2) @NotNull double price,
                      @NotBlank @Size(max = 15) String publisher,
                      @NotNull Genre genre) {
}
