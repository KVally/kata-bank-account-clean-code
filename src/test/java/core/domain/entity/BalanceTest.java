package core.domain.entity;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BalanceTest {

    private Balance balance;
    private Account account;

    @BeforeEach
    void setUp() {
        Double amount = 750.0;
        this.balance = new Balance(amount);
        this.account = new Account(new AccountNumber("1234567890"));
    }

    @Test
    void add() {
        balance.add(new TransactionAmount(account,300.0, TransactionAmount.TransactionType.DEPOSIT));
        assertEquals(balance.getAmount(),1050.0);
    }

    @Test
    void subtract() {
        balance.subtract(new TransactionAmount(account,500.0, TransactionAmount.TransactionType.WITHDRAW));
        assertEquals(balance.getAmount(),250.0);
    }
}