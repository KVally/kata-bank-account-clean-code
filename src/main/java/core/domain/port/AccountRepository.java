package core.domain.port;

import core.domain.entity.Account;
import core.domain.entity.AccountNumber;

import java.util.Optional;
import java.util.UUID;

public interface AccountRepository extends BaseRepositoryPort<Account, UUID> {
    Optional<Account> findByAccountNumber(AccountNumber accountNumber);
}
