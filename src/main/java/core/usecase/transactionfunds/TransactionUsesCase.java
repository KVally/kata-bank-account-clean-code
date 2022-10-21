package core.usecase.transactionfunds;

import core.domain.entity.Account;
import core.domain.entity.AccountNumber;
import core.domain.exception.ValidationException;
import core.domain.exception.ValidationMessages;
import core.domain.port.AccountRepository;
import core.domain.port.TransactionRepository;
import core.usecase.UseCaseExecutor;

import java.util.List;

public class TransactionUsesCase implements UseCaseExecutor<List<TransactionResponse>,TransactionRequest> {
    final TransactionRepository transactionRepository;
    final AccountRepository accountRepository;

    public TransactionUsesCase(TransactionRepository transactionRepository, AccountRepository accountRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public List<TransactionResponse> execute(TransactionRequest request) {
        var account = getAccount(new AccountNumber(request.getAccountNumber()));
        var transactionAmounts = transactionRepository.findByAccountNumberAndDateBetween(
                account,
                request.getStartDate(),
                request.getEndDate()
        );
        return TransactionResponse.fromList(transactionAmounts);
    }

    private Account getAccount(AccountNumber accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(()-> new ValidationException(ValidationMessages.ACCOUNT_NUMBER_NOT_EXIST));
    }
}