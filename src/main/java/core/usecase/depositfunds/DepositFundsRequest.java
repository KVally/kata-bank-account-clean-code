package core.usecase.depositfunds;

public class DepositFundsRequest {
    private String accountNumber;
    private int amount;

    public DepositFundsRequest(String accountNumber, int amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
