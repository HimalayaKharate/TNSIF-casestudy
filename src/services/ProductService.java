package services;

import entities.Product;
import repositories.ProductRepo;

import java.util.Scanner;

public class ProductService {
    ProductRepo productRepo = new ProductRepo();

    public void addProduct(Scanner scanner) {
        System.out.println("Enter product Id : ");
        int productId = scanner.nextInt();
        System.out.println("Enter product Name : ");
        String productName = scanner.next();
        System.out.println("Enter product price : ");
        double productPrice = scanner.nextDouble();
        System.out.println("Enter product quantity : ");
        int productQuantity = scanner.nextInt();
        Product product = new Product(productId, productName, productPrice, productQuantity);
        productRepo.add(product);
    }

    public void removeProduct(int productId) {
        productRepo.removeProduct(productId);
    }

    public void listProducts() {
        System.out.println(String.format("| %-10s | %-30s | %-10s | %-10s |", "Product ID", "Product Name", "Price", "Stock Qty"));
        System.out.println("-------------------------------------------------------------");
        for (Product product : productRepo.getProducts()) {
            System.out.println(product);
        }
        System.out.println("-------------------------------------------------------------");
    }

    public void getProductById(int productId) {
        Product product = productRepo.getProductById(productId);
        System.out.println(product);
    }

    public ProductRepo getProductRepo() {
        return productRepo;
    }
}
