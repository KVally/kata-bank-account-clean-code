package core.domain.entity;

public class Balance {
    private Double amount;

    public Balance(Double amount) {
        this.amount = amount;
    }

    public Balance add(TransactionAmount transactionAmount){
        this.amount += transactionAmount.getAmount();
        return this;
    }

    public Balance subtract(TransactionAmount transactionAmount){
        this.amount -= transactionAmount.getAmount();
        return this;
    }

    public Double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Balance{" +
                "amount=" + amount +
                '}';
    }
}
