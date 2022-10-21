package core.usecase.transactionfunds;

import java.util.Date;

public class TransactionRequest {
    private String accountNumber;
    private Date startDate;
    private Date endDate;

    public TransactionRequest(String accountNumber, Date startDate, Date endDate) {
        this.accountNumber = accountNumber;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
