package id.co.mybank.services;

import id.co.mybank.dto.ApiResponse;
import id.co.mybank.entity.Account;
import id.co.mybank.repository.AccountRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.jboss.logging.Logger;

import java.util.List;

@ApplicationScoped
public class AccountService {
    @Inject
    AccountRepository accountRepository;

    static final Logger log = Logger.getLogger(AccountService.class);

    public ApiResponse<List<Account>> getAllAccount() {
        try {
            List<Account> accounts = accountRepository.getAll();
            return ApiResponse.success("Success", accounts);
        } catch (Exception e) {
            return ApiResponse.error(500, e.getMessage());
        }
    }

    public ApiResponse<Account> getAccountByAccountNumber(String accountNumber) {
        try {
            Account account = accountRepository.findById(accountNumber);
            if (account == null) {
                return ApiResponse.error(404, "Customer not found");
            }
            return ApiResponse.success("Success", account);
        } catch (Exception e) {
            return ApiResponse.error(500, e.getMessage());
        }
    }

    @Transactional
    public ApiResponse<Account> saveOrUpdateAccount(Account data) {
        try {
            if (data.getAccountNumber() == null) {
                accountRepository.persist(data);
                return ApiResponse.success("Success", data);
            }

            Account account = accountRepository.findById(data.getAccountNumber());
            account.setBalance(data.getBalance());
            account.setCustomer(data.getCustomer());
            accountRepository.persist(account);
            return ApiResponse.success("Success", account);
        } catch (Exception e) {
            return ApiResponse.error(500, e.getMessage());
        }
    }
}
