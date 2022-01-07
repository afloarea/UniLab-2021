package ro.unibuc.lab11.main.service;

import ro.unibuc.lab11.main.dto.CoinDetails;
import ro.unibuc.lab11.main.dto.CreateTransactionResponse;
import ro.unibuc.lab11.main.dto.TransactionDetailsRequest;
import ro.unibuc.lab11.main.dto.TransactionDetailsResponse;

public interface CryptoService {

    void addCoin(CoinDetails coinDetails);

    TransactionDetailsResponse fetchTransactionDetails(String transactionId);

    CreateTransactionResponse createTransaction(TransactionDetailsRequest request);

}
