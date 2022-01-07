package ro.unibuc.lab11.main.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ro.unibuc.lab11.main.dto.CoinDetails;
import ro.unibuc.lab11.main.dto.CreateTransactionResponse;
import ro.unibuc.lab11.main.dto.TransactionDetailsRequest;
import ro.unibuc.lab11.main.dto.TransactionDetailsResponse;
import ro.unibuc.lab11.main.exceptions.NoCoinException;
import ro.unibuc.lab11.main.exceptions.NoTransactionException;
import ro.unibuc.lab11.main.service.CryptoService;

import javax.validation.Valid;
import java.util.Map;

@RestController
@Validated
public class CryptoController {

    private final CryptoService cryptoService;

    public CryptoController(CryptoService cryptoService) {
        this.cryptoService = cryptoService;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("/coins")
    public void addCoin(@RequestBody @Valid CoinDetails coinDetails) {
        cryptoService.addCoin(coinDetails);
    }

    @GetMapping("/transactions/{transactionId}")
    public TransactionDetailsResponse getTransaction(@PathVariable String transactionId) {
        return cryptoService.fetchTransactionDetails(transactionId);
    }

    @PostMapping("/transactions")
    public CreateTransactionResponse createTransaction(@RequestBody @Valid TransactionDetailsRequest request) {
        return cryptoService.createTransaction(request);
    }

    @ExceptionHandler(NoCoinException.class)
    public ResponseEntity<Map<String, String>> handleNoCoin(NoCoinException ex) {
        return ResponseEntity.status(400).body(Map.of("message", "No coin for transaction"));
    }

    @ExceptionHandler(NoTransactionException.class)
    public ResponseEntity<Map<String, String>> handleNoTransaction(NoTransactionException ex) {
        return ResponseEntity.status(404).body(Map.of("message", "No transaction found"));
    }

}
