package id.co.mybank.repository;

import id.co.mybank.entity.Transaction;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class TransactionRepository implements PanacheRepository<Transaction> {
    public List<Transaction> getAll() {
        return listAll();
    }

    public List<Transaction> findTransactionByAccountNumber(String accountNumber) {
        return find("accountNumber", accountNumber).stream().toList();
    }
}
