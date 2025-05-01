package id.co.mybank.repository;

import id.co.mybank.entity.TransactionTransfer;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TransactionTransferRepository implements PanacheRepository<TransactionTransfer> {
    public TransactionTransfer findByTransactionId(String transactionId) {
        return find("transactionId", transactionId).firstResult();
    }
}
