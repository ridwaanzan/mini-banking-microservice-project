package id.co.mybank.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "mt_accounts")
public class Account {
    @Id
    @Column(name = "account_number")
    private String accountNumber;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "balance")
    private Double balance;

    @Column(name = "created_date")
    private LocalDate createdDate;

    public Account() {
    }

    public Account(String accountNumber, Customer customer, Product product, Double balance, LocalDate createdDate) {
        this.accountNumber = accountNumber;
        this.customer = customer;
        this.product = product;
        this.balance = balance;
        this.createdDate = createdDate;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }
}
