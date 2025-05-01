package id.co.mybank.repository;

import id.co.mybank.entity.Customer;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class CustomerRepository implements PanacheRepository<Customer> {
    public List<Customer> getAll() {
        return listAll();
    }

    public Customer findByEmail(String email) {
        return find("email", email).firstResult();
    }
}
