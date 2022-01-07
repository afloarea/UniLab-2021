package ro.unibuc.lab11.main.service;

import org.springframework.stereotype.Service;
import ro.unibuc.lab11.main.Transaction;
import ro.unibuc.lab11.main.dto.CoinDetails;
import ro.unibuc.lab11.main.dto.CreateTransactionResponse;
import ro.unibuc.lab11.main.dto.TransactionDetailsRequest;
import ro.unibuc.lab11.main.dto.TransactionDetailsResponse;
import ro.unibuc.lab11.main.exceptions.NoCoinException;
import ro.unibuc.lab11.main.exceptions.NoTransactionException;
import ro.unibuc.lab11.main.repos.CryptoRepository;

@Service
public class CryptoServiceImpl implements CryptoService {

    private final CryptoRepository repo;

    public CryptoServiceImpl(CryptoRepository repo) {
        this.repo = repo;
    }

    @Override
    public void addCoin(CoinDetails coinDetails) {
        repo.addCoin(coinDetails.id());
    }

    @Override
    public TransactionDetailsResponse fetchTransactionDetails(String transactionId) {
        final var transaction = repo.findTransactionById(transactionId);
        if (transaction == null) {
            throw new NoTransactionException();
        }
        return new TransactionDetailsResponse(
                transaction.getId(),
                transaction.getSourceWallet(),
                transaction.getTargetWallet(),
                transaction.getAmount(),
                transaction.getDateTime(),
                transaction.getCoin());
    }

    @Override
    public CreateTransactionResponse createTransaction(TransactionDetailsRequest request) {
        if (!repo.hasCoin(request.coin())) {
            throw new NoCoinException();
        }

        final var transaction = new Transaction();
        transaction.setAmount(request.amount());
        transaction.setDateTime(request.dateTime());
        transaction.setSourceWallet(request.sourceWallet());
        transaction.setTargetWallet(request.targetWallet());
        transaction.setCoin(request.coin());

        final var id = repo.addTransaction(transaction);

        return new CreateTransactionResponse(id);
    }
}
