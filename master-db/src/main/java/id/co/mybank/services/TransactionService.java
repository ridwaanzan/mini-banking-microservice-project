package id.co.mybank.services;

import id.co.mybank.dto.ApiResponse;
import id.co.mybank.entity.Transaction;
import id.co.mybank.repository.TransactionRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class TransactionService {
    @Inject
    TransactionRepository transactionRepository;

    public ApiResponse<List<Transaction>> getAllTransaction() {
        try {
            List<Transaction> data = transactionRepository.getAll();
            return ApiResponse.success("Success", data);
        } catch (Exception e) {
            return ApiResponse.error(500, e.getMessage());
        }
    }

    public ApiResponse<Transaction> getTransactionById(Long id) {
        try {
            Transaction data = transactionRepository.findById(id);
            if (data == null) {
                return ApiResponse.error(404, "Transaction not found");
            }
            return ApiResponse.success("Success", data);
        } catch (Exception e) {
            return ApiResponse.error(500, e.getMessage());
        }
    }

    public ApiResponse<Transaction> saveOrUpdateTransaction(Transaction data) {
        try {
            if (data.getId() == null) {
                transactionRepository.persist(data);
                return ApiResponse.success("Success", data);
            }

            Transaction transaction = transactionRepository.findById(data.getId());
            transaction.setTransactionDate(data.getTransactionDate());
            transaction.setTransactionAmount(data.getTransactionAmount());
            transactionRepository.persist(transaction);
            return ApiResponse.success("Success", transaction);
        } catch (Exception e) {
            return ApiResponse.error(500, e.getMessage());
        }
    }
}
