package core.usecase.transactionfunds;

import core.domain.entity.TransactionAmount;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionResponse {
    private Date date;
    private Double amount;
    private TransactionAmount.TransactionType transactionType;

    public TransactionResponse(Date date, Double amount, TransactionAmount.TransactionType transactionType) {
        this.date = date;
        this.amount = amount;
        this.transactionType = transactionType;
    }

    public static TransactionResponse from(TransactionAmount transactionAmount){
        return new TransactionResponse(
                transactionAmount.getDate(),
                transactionAmount.getAmount(),
                transactionAmount.getTransactionType()
        );
    }

    public static List<TransactionResponse> fromList(List<TransactionAmount> transactionAmounts){
        return transactionAmounts.stream().map(TransactionResponse::from).collect(Collectors.toList());
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public TransactionAmount.TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionAmount.TransactionType transactionType) {
        this.transactionType = transactionType;
    }
}
