package repository;

import core.domain.entity.Account;
import core.domain.entity.AccountNumber;
import core.domain.port.AccountRepository;

import java.util.Optional;
import java.util.UUID;

public class FakeAccountRepository implements AccountRepository {
    private final String _AccountNumber1 ="1234567890";
    private final String _AccountNumber2 ="0987654321";

    @Override
    public Optional<Account> findByAccountNumber(AccountNumber accountNumber) {
        AccountNumber accountNumber1 = new AccountNumber(this._AccountNumber1);
        AccountNumber accountNumber2 = new AccountNumber(this._AccountNumber2);
        if (accountNumber.equals(accountNumber1) || accountNumber.equals(accountNumber2)){
            return Optional.of(new Account(accountNumber));
        }
        return Optional.empty();
    }

    @Override
    public Account save(Account model) {
        return model;
    }

    @Override
    public Account update(Account model) {
        return model;
    }

    @Override
    public Optional<Account> findById(UUID uuid) {
        return Optional.empty();
    }
}
