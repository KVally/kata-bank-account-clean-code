package core.domain.entity;

import core.domain.exception.ValidationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    private Account account;
    @BeforeEach
    void setUp() {
        this.account = new Account(new AccountNumber("1234567890"));
    }

    @Test
    void deposit() {
        account.deposit(new TransactionAmount(account,(double)3000, TransactionAmount.TransactionType.DEPOSIT));
        account.deposit(new TransactionAmount(account,(double)500, TransactionAmount.TransactionType.DEPOSIT));
        assertEquals(account.getBalance().getAmount(),(double) 3500);
    }

    @Test
    void withdraw() {
        account.deposit(new TransactionAmount(account,(double)3000, TransactionAmount.TransactionType.DEPOSIT));
        account.withdraw(new TransactionAmount(account,(double)500, TransactionAmount.TransactionType.WITHDRAW));
        assertEquals(account.getBalance().getAmount(),(double) 2500);
    }

    @Test
    void testFailedWithdraw() {
        assertThrows(
                ValidationException.class,
                ()->account.withdraw(new TransactionAmount(account,(double)500, TransactionAmount.TransactionType.WITHDRAW))
                );
    }
}