package id.co.mybank.transaction_service.services;

import id.co.mybank.transaction_service.dto.ApiResponse;
import id.co.mybank.transaction_service.dto.TransactionRequestDto;
import id.co.mybank.transaction_service.dto.TransactionResponseDto;
import id.co.mybank.transaction_service.helper.ApiCaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TransactionService {
    @Autowired
    ApiCaller apiCaller;

    @Value("${host.core.minibanking.url}")
    private String coreUrl;

    // insert transaction
    public ApiResponse<TransactionResponseDto> insertTransaction(TransactionRequestDto transaction) {
        apiCaller.postDataToUrl(coreUrl.concat("saveOrUpdate"), transaction, Map.class);
        apiCaller.postDataToUrl(coreUrl.concat("saveOrUpdate"), transaction, Map.class);
    }

    // insert transaction transfer
}
