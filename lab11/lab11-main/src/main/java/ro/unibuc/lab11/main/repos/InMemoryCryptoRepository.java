package ro.unibuc.lab11.main.repos;

import org.springframework.stereotype.Repository;
import ro.unibuc.lab11.main.Transaction;

import java.util.*;

@Repository
public class InMemoryCryptoRepository implements CryptoRepository {

    private final Set<String> coinSet = new HashSet<>();
    private final Map<String, Transaction> transactionMap = new HashMap<>();

    @Override
    public void addCoin(String coin) {
        coinSet.add(coin);
    }

    @Override
    public boolean hasCoin(String coin) {
        return coinSet.contains(coin);
    }

    @Override
    public String addTransaction(Transaction transaction) {
        final var transactionId = UUID.randomUUID().toString();
        transaction.setId(transactionId);
        transactionMap.put(transactionId, transaction);
        return transactionId;
    }

    @Override
    public Transaction findTransactionById(String id) {
        return transactionMap.get(id);
    }
}
