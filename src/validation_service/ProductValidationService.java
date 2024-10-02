package validation_service;

import entities.Product;

import java.util.List;

public class ProductValidationService {

    public boolean validateProduct(Product product, List<Product> products) {
        return products.stream()
                .noneMatch(
                        product1 -> product1.getProductId() == product.getProductId() &&
                                    product1.getProductName().equals(product.getProductName()));

    }
}
