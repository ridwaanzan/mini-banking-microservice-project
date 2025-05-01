package id.co.mybank.repository;

import id.co.mybank.entity.Account;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class AccountRepository implements PanacheRepositoryBase<Account, String> {
    public List<Account> getAll() {
        return listAll();
    }
}
