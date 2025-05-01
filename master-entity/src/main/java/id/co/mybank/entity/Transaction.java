package id.co.mybank.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "mt_transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "transaction_date")
    private LocalDateTime transactionDate;

    @Column(name = "transaction_amount")
    private Double transactionAmount;

    @Column(name = "type")
    private String type;

    public Transaction() {
    }

    public Transaction(Long id, LocalDateTime transactionDate, Double transactionAmount, String type) {
        this.id = id;
        this.transactionDate = transactionDate;
        this.transactionAmount = transactionAmount;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(Double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
