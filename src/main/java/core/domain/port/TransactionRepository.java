package core.domain.port;

import core.domain.entity.Account;
import core.domain.entity.AccountNumber;
import core.domain.entity.TransactionAmount;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface TransactionRepository extends BaseRepositoryPort<TransactionAmount, UUID> {
    List<TransactionAmount> findByAccountNumber(AccountNumber accountNumber);
    List<TransactionAmount> findByAccountNumberAndDateBetween(Account account, Date startDate, Date endDate);
}
