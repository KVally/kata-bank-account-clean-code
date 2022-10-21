package repository;

import core.domain.entity.Account;
import core.domain.entity.AccountNumber;
import core.domain.entity.TransactionAmount;
import core.domain.port.AccountRepository;
import core.domain.port.TransactionRepository;

import java.util.*;
import java.util.stream.Collectors;

public class FakeTransactionRepository implements TransactionRepository {
    private final String _AccountNumber1 ="1234567890";
    private final String _AccountNumber2 ="0987654321";

    @Override
    public TransactionAmount save(TransactionAmount model) {
        return null;
    }

    @Override
    public TransactionAmount update(TransactionAmount model) {
        return null;
    }

    @Override
    public Optional<TransactionAmount> findById(UUID uuid) {
        return Optional.empty();
    }

    @Override
    public List<TransactionAmount> findByAccountNumber(AccountNumber accountNumber) {
        List<TransactionAmount> transactionAmounts = list();
        return transactionAmounts.stream().filter(transactionAmount -> transactionAmount.getAccount().getAccountNumber().equals(accountNumber))
                .collect(Collectors.toList());
    }

    @Override
    public List<TransactionAmount> findByAccountNumberAndDateBetween(Account account, Date startDate, Date endDate) {
        List<TransactionAmount> transactionAmounts = list();
        return transactionAmounts.stream().filter(transactionAmount -> transactionAmount.getAccount().getAccountNumber().equals(account.getAccountNumber()))
                .collect(Collectors.toList());
    }

    public List<TransactionAmount> list (){
        List<core.domain.entity.TransactionAmount> transactionAmounts = new ArrayList<>();
        Account account1 = new Account(new AccountNumber(_AccountNumber1));
        core.domain.entity.TransactionAmount transactionAmount1 = new core.domain.entity.TransactionAmount(
                account1,
                750.0,
                core.domain.entity.TransactionAmount.TransactionType.DEPOSIT
        );

        core.domain.entity.TransactionAmount transactionAmount2 = new core.domain.entity.TransactionAmount(
                account1,
                300.0,
                core.domain.entity.TransactionAmount.TransactionType.WITHDRAW
        );
        transactionAmounts.add(transactionAmount1);
        transactionAmounts.add(transactionAmount2);

        return transactionAmounts;
    }
}
