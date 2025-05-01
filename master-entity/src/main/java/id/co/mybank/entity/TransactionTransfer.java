package id.co.mybank.entity;

import jakarta.persistence.*;

@Entity(name = "mt_transaction_transfers")
public class TransactionTransfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "transaction_id")
    private Transaction transactionId;

    @ManyToOne
    @JoinColumn(name = "beneficiary_account", referencedColumnName = "account_number")
    private Account beneficiaryAccount;

    @Column(name = "status")
    private String status;

    public TransactionTransfer() {
    }

    public TransactionTransfer(Long id, Transaction transactionId, Account beneficiaryAccount, String status) {
        this.id = id;
        this.transactionId = transactionId;
        this.beneficiaryAccount = beneficiaryAccount;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Transaction getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Transaction transactionId) {
        this.transactionId = transactionId;
    }

    public Account getBeneficiaryAccount() {
        return beneficiaryAccount;
    }

    public void setBeneficiaryAccount(Account beneficiaryAccount) {
        this.beneficiaryAccount = beneficiaryAccount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
