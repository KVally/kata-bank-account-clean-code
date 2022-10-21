package core.usecase.transactionfunds;

import core.domain.entity.Account;
import core.domain.entity.AccountNumber;
import core.domain.exception.ValidationException;
import core.domain.port.AccountRepository;
import core.domain.port.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.FakeAccountRepository;
import repository.FakeTransactionRepository;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TransactionUsesCaseTest {

    private AccountRepository accountRepository;
    private TransactionRepository transactionRepository;
    private TransactionUsesCase transactionUsesCase;
    private Account account;

    @BeforeEach
    void setUp() {
        this.accountRepository = new FakeAccountRepository();
        this.transactionRepository = new FakeTransactionRepository();
        this.account = new Account(new AccountNumber("1234567890"));
        this.transactionUsesCase = new TransactionUsesCase(this.transactionRepository, this.accountRepository);
    }

    @Test
    void testHappyRunTransaction() {
        String goodAccountNumber = "1234567890";
        var transactionRequest = new TransactionRequest(goodAccountNumber,new Date(),new Date());
        var transactions = transactionUsesCase.execute(transactionRequest);
        assertEquals(transactions.size(),2);
    }

    @Test
    void testFailedTransaction() {
        String fakeAccountNumber = "0000000001";
        var transactionRequest = new TransactionRequest(fakeAccountNumber,new Date(),new Date());
        assertThrows(ValidationException.class,()->transactionUsesCase.execute(transactionRequest));
    }

}