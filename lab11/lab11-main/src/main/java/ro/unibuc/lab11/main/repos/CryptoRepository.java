package ro.unibuc.lab11.main.repos;

import ro.unibuc.lab11.main.Transaction;

public interface CryptoRepository {

    void addCoin(String coin);

    boolean hasCoin(String coin);

    String addTransaction(Transaction transaction);

    Transaction findTransactionById(String id);

}
