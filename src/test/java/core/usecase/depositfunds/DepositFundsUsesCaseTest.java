package core.usecase.depositfunds;

import core.domain.entity.Account;
import core.domain.entity.AccountNumber;
import core.domain.exception.ValidationException;
import core.domain.port.AccountRepository;
import org.junit.jupiter.api.*;
import repository.FakeAccountRepository;

import static org.junit.jupiter.api.Assertions.*;

class DepositFundsUsesCaseTest {

    private AccountRepository accountRepository;
    private DepositFundsUsesCase depositFundsUsesCase;
    private Account account;

    @BeforeEach
    void setUp() {
        this.accountRepository = new FakeAccountRepository();
        String goodAccountNumber = "1234567890";
        this.account = new Account(new AccountNumber(goodAccountNumber));
        this.depositFundsUsesCase = new DepositFundsUsesCase(this.accountRepository);
    }

    @Test
    void testHappyRunDeposit(){
        var depositRequest = new DepositFundsRequest(account.getAccountNumber().getValue(),750);
        assertDoesNotThrow(()->depositFundsUsesCase.execute(depositRequest));
    }

    @Test
    void testFailedDeposit(){
        String fakeAccountNumber = "0000000001";
        var depositRequest = new DepositFundsRequest(fakeAccountNumber,750);
        assertThrows(ValidationException.class,()->depositFundsUsesCase.execute(depositRequest));
    }
}