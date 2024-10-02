package entities;

public class Product {
    private long productId;
    private String productName;
    private double price;
    private int stockQty;

    public Product() {
    }

    public Product(long productId, String productName, double price, int stockQty) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.stockQty = stockQty;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockQty() {
        return stockQty;
    }

    public void setStockQty(int stockQty) {
        this.stockQty = stockQty;
    }

    @Override
    public String toString() {
        return String.format("| %-10d | %-30s | %-10.2f | %-10d |", productId, productName, price, stockQty);
    }
}
