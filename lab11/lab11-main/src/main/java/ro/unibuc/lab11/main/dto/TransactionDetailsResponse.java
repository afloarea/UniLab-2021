package ro.unibuc.lab11.main.dto;

import java.time.LocalDateTime;

public record TransactionDetailsResponse(String transactionId,
                                         String sourceWallet,
                                         String targetWallet,
                                         double amount,
                                         LocalDateTime dateTime,
                                         String coin) {
}
