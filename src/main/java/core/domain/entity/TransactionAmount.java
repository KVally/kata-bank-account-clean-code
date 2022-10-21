package core.domain.entity;

import java.util.Date;
import java.util.UUID;

public class TransactionAmount {
    private final UUID id;
    private final Account account;
    private final Date date;
    private final Double amount;
    private TransactionType transactionType;

    public TransactionAmount(Account account, Double amount, TransactionType transactionType) {
        this.account = account;
        this.id=UUID.randomUUID();
        this.date = new Date();
        this.amount = amount;
        this.transactionType=transactionType;
    }

    public boolean greaterThan(Double amount) {
        return this.amount > amount;
    }

    public UUID getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public Account getAccount() {
        return account;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public Double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "TransactionAmount{" +
                "id=" + id +
                ", date=" + date +
                ", amount=" + amount +
                ", transactionType=" + transactionType +
                '}';
    }

    public enum TransactionType {
        DEPOSIT,
        WITHDRAW
    }
}
