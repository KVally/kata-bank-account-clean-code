package core.usecase.withdrawfunds;

import core.domain.entity.Account;
import core.domain.entity.AccountNumber;
import core.domain.entity.TransactionAmount;
import core.domain.exception.ValidationException;
import core.domain.exception.ValidationMessages;
import core.domain.port.AccountRepository;
import core.usecase.VoidUseCaseExecutor;

public class WithdrawFundsUsesCase implements VoidUseCaseExecutor<WithdrawFundsRequest> {
    final AccountRepository accountRepository;

    public WithdrawFundsUsesCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void execute(WithdrawFundsRequest request) {
        var account = getAccount(new AccountNumber(request.getAccountNumber()));
        var transactionAmount = getTransactionAmount(account, (double) request.getAmount());
        account.withdraw(transactionAmount);
        accountRepository.update(account);
    }

    private Account getAccount(AccountNumber accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(()-> new ValidationException(ValidationMessages.ACCOUNT_NUMBER_NOT_EXIST));
    }

    private TransactionAmount getTransactionAmount(Account account, Double amount) {
        return new TransactionAmount(account, amount, TransactionAmount.TransactionType.WITHDRAW);
    }
}