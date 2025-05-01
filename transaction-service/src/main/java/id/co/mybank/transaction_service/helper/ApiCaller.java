package id.co.mybank.transaction_service.helper;

import id.co.mybank.transaction_service.dto.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

public class ApiCaller {
    private final RestTemplate restTemplate;

    public ApiCaller() {
        this.restTemplate = new RestTemplate();
    }

    public <T> T getDataFromUrl(String url, Class<T> responseType) {
        ResponseEntity<ApiResponse<T>> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                ParameterizedTypeReference.forType(ApiResponse.class)
        );

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            ApiResponse<T> body = responseEntity.getBody();
            if (body != null && body.isSuccess()) {
                return body.getData();
            }
        }

        throw new RuntimeException("Error while calling API with get method.");
    }

    public <T, R> T postDataToUrl(String url, R requestBody, Class<T> responseType) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<R> entity = new HttpEntity<>(requestBody, headers);
        ResponseEntity<ApiResponse<T>> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.POST,
                entity,
                new ParameterizedTypeReference<ApiResponse<T>>() {}
        );

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            ApiResponse<T> body = responseEntity.getBody();
            if (body != null && body.isSuccess()) {
                return body.getData();
            }
        }

        throw new RuntimeException("Error while calling API with post method.");
    }
}
