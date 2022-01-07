package ro.unibuc.lab11.main;

import java.time.LocalDateTime;
import java.util.Objects;

public final class Transaction {
    private String id;
    private String sourceWallet;
    private String targetWallet;
    private double amount;
    private LocalDateTime dateTime;
    private String coin;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSourceWallet() {
        return sourceWallet;
    }

    public void setSourceWallet(String sourceWallet) {
        this.sourceWallet = sourceWallet;
    }

    public String getTargetWallet() {
        return targetWallet;
    }

    public void setTargetWallet(String targetWallet) {
        this.targetWallet = targetWallet;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transaction)) return false;
        Transaction that = (Transaction) o;
        return Double.compare(that.amount, amount) == 0 && Objects.equals(id, that.id) && Objects.equals(sourceWallet, that.sourceWallet) && Objects.equals(targetWallet, that.targetWallet) && Objects.equals(dateTime, that.dateTime) && Objects.equals(coin, that.coin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sourceWallet, targetWallet, amount, dateTime, coin);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", sourceWallet='" + sourceWallet + '\'' +
                ", targetWallet='" + targetWallet + '\'' +
                ", amount=" + amount +
                ", dateTime=" + dateTime +
                ", coin='" + coin + '\'' +
                '}';
    }
}
