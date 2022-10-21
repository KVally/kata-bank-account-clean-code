package core.usecase.withdrawfunds;

import core.domain.entity.Account;
import core.domain.entity.AccountNumber;
import core.domain.exception.ValidationException;
import core.domain.port.AccountRepository;
import core.usecase.withdrawfunds.WithdrawFundsRequest;
import core.usecase.withdrawfunds.WithdrawFundsUsesCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.FakeAccountRepository;

import static org.junit.jupiter.api.Assertions.*;

class WithdrawFundsUsesCaseTest {

    private AccountRepository accountRepository;
    private WithdrawFundsUsesCase withdrawFundsUsesCase;
    private Account account;

    @BeforeEach
    void setUp() {
        this.accountRepository = new FakeAccountRepository();
        String goodAccountNumber = "1234567890";
        this.account = new Account(new AccountNumber(goodAccountNumber));
        this.withdrawFundsUsesCase = new WithdrawFundsUsesCase(this.accountRepository);
    }

    @Test
    void testFailedWithdrawInssufisantFunds(){
        var withdrawRequest = new WithdrawFundsRequest(account.getAccountNumber().getValue(),750);
        assertThrows(ValidationException.class,()->withdrawFundsUsesCase.execute(withdrawRequest));
    }

    @Test
    void testFailedWithdrawAccountDoesNotExist(){
        String fakeAccountNumber = "0000000001";
        var withdrawRequest = new WithdrawFundsRequest(fakeAccountNumber,750);
        assertThrows(ValidationException.class,()->withdrawFundsUsesCase.execute(withdrawRequest));
    }
}