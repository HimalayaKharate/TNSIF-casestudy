package repositories;

import entities.Product;
import validation_service.ProductValidationService;

import java.util.ArrayList;
import java.util.List;

public class ProductRepo {
    private List<Product> products = new ArrayList<Product>();
    private ProductValidationService validationService = new ProductValidationService();

    public void add(Product product) {
        if(validationService.validateProduct(product, products)){
            products.add(product);
        }else{
            System.out.println("Invalid product");
        }
    }

    public boolean removeProduct(int productId) {
        return products.removeIf(product -> product.getProductId() == productId);
    }

    public List<Product> getProducts() {
        return products;
    }

    public Product getProductById(int productId) {
        return products.stream().filter(product -> product.getProductId() == productId).findFirst().orElse(null);
    }


}
