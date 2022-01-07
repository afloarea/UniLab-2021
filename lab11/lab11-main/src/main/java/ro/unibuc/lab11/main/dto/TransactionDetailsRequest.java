package ro.unibuc.lab11.main.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

public record TransactionDetailsRequest(@NotNull String sourceWallet,
                                        @NotNull String targetWallet,
                                        @NotNull @Positive @Digits(integer = Integer.MAX_VALUE, fraction = 2) Double amount,
                                        @NotNull LocalDateTime dateTime,
                                        @NotNull @Pattern(regexp = "^[A-Z]{3}$") String coin) {
}
