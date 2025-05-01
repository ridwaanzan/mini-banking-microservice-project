package id.co.mybank.services;

import id.co.mybank.dto.ApiResponse;
import id.co.mybank.entity.Customer;
import id.co.mybank.repository.CustomerRepository;
import io.vertx.core.json.JsonObject;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.jboss.logging.Logger;

import java.util.List;

@ApplicationScoped
public class CustomerService {
    @Inject
    CustomerRepository repository;

    public Object getAllCustomer() {
        try {
            List<Customer> data = repository.getAll();
            return ApiResponse.success("Success", data);
        } catch (Exception e) {
            return ApiResponse.error(500, e.getMessage());
        }
    }

    public ApiResponse<Customer> getCustomerByEmail(String email) {
        try {
            Customer data = repository.findByEmail(email);
            if (data == null) {
                return ApiResponse.error(404, "Customer not found");
            }
            return ApiResponse.success("Success", data);
        } catch (Exception e) {
            return ApiResponse.error(500, e.getMessage());
        }
    }

    @Transactional
    public Object saveOrUpdateCustomer(Customer data) {
        try {
            if (data.getId() == null) {
                repository.persist(data);
                return ApiResponse.success("Success", data);
            }

            Customer customer = repository.findById(data.getId());
            customer.setFirstName(data.getFirstName());
            customer.setLastName(data.getLastName());
            customer.setEmail(data.getEmail());
            customer.setBirthDate(data.getBirthDate());
            repository.persist(customer);
            return ApiResponse.success("Success", customer);
        } catch (Exception e) {
            return ApiResponse.error(500, e.getMessage());
        }
    }
}
