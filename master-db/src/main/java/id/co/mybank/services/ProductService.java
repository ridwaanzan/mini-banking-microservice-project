package id.co.mybank.services;

import id.co.mybank.dto.ApiResponse;
import id.co.mybank.entity.Product;
import id.co.mybank.repository.ProductRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class ProductService {
    @Inject
    ProductRepository productRepository;

    public ApiResponse<List<Product>> getAllProduct() {
        try {
            List<Product> data = productRepository.getAll();
            return ApiResponse.success("Success", data);
        } catch (Exception e) {
            return ApiResponse.error(500, e.getMessage());
        }
    }

    public ApiResponse<Product> getProductById(Long id) {
        try {
            Product product = productRepository.findById(id);
            if (product == null) {
                return ApiResponse.error(404, "Product not found");
            }
            return ApiResponse.success("Success", product);
        } catch (Exception e) {
            return ApiResponse.error(500, e.getMessage());
        }
    }

    public ApiResponse<Product> saveOrUpdateProduct(Product data) {
        try {
            if (data.getId() == null) {
                productRepository.persist(data);
                return ApiResponse.success("Success", data);
            }

            Product product = productRepository.findById(data.getId());
            product.setName(data.getName());
            product.setDescription(data.getDescription());
            productRepository.persist(data);
            return ApiResponse.success("Success", data);
        } catch (Exception e) {
            return ApiResponse.error(500, e.getMessage());
        }
    }
}
