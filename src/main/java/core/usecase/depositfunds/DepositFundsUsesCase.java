package core.usecase.depositfunds;

import core.domain.entity.Account;
import core.domain.entity.AccountNumber;
import core.domain.entity.TransactionAmount;
import core.domain.exception.ValidationException;
import core.domain.exception.ValidationMessages;
import core.domain.port.AccountRepository;
import core.usecase.VoidUseCaseExecutor;

public class DepositFundsUsesCase implements VoidUseCaseExecutor<DepositFundsRequest> {
    final AccountRepository accountRepository;

    public DepositFundsUsesCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void execute(DepositFundsRequest request) {
        var account = getAccount(new AccountNumber(request.getAccountNumber()));
        var transactionAmount = getTransactionAmount(account, (double) request.getAmount());
        account.deposit(transactionAmount);
        accountRepository.update(account);
    }

    private Account getAccount(AccountNumber accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(()-> new ValidationException(ValidationMessages.ACCOUNT_NUMBER_NOT_EXIST));
    }

    private TransactionAmount getTransactionAmount(Account account, Double amount) {
        return new TransactionAmount(account, amount, TransactionAmount.TransactionType.DEPOSIT);
    }

}