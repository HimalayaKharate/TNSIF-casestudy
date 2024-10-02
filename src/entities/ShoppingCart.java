package entities;

import java.util.HashMap;

import java.util.Map;

public class ShoppingCart {
    private int customerId;
    private final Map<Product, Integer> items;
    {
        items = new HashMap<Product, Integer>();

    }

    public ShoppingCart() {}

    public ShoppingCart(int customerId) {
        this.customerId = customerId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Map<Product, Integer> getItems() {
        return items;
    }


}
