package core.domain.entity;

import core.domain.exception.ValidationException;
import core.domain.exception.ValidationMessages;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Account {
    private final UUID id;
    private final AccountNumber accountNumber;
    private Balance balance;
    private Set<TransactionAmount> transactionAmounts;

    public Account(AccountNumber accountNumber) {
        this.id = UUID.randomUUID();
        this.accountNumber = accountNumber;
        this.balance =new Balance((double) 0);
        transactionAmounts = new HashSet<>();
    }

    public void deposit(TransactionAmount amount) {
        balance = balance.add(amount);
        transactionAmounts.add(amount);
    }

    public void withdraw(TransactionAmount amount) {
        if (amount.greaterThan(balance.getAmount())) {
            throw new ValidationException(ValidationMessages.INSUFFICIENT_FUNDS);
        }
        balance = balance.subtract(amount);
        transactionAmounts.add(amount);
    }

    public AccountNumber getAccountNumber() {
        return accountNumber;
    }

    public Balance getBalance() {
        return balance;
    }

    public Set<TransactionAmount> getTransactionAmounts() {
        return transactionAmounts;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountNumber=" + accountNumber +
                ", balance=" + balance +
                ", transactionAmounts=" + transactionAmounts +
                '}';
    }
}
