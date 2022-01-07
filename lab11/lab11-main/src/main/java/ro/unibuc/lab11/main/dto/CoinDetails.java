package ro.unibuc.lab11.main.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public record CoinDetails(@NotNull @Pattern(regexp = "^[A-Z]{3}$") String id,
                          @NotNull @Size(min = 3) String name,
                          CoinType type) {
}
