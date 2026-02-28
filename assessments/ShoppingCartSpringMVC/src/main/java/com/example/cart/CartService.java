
package com.example.cart;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CartService {
    private final Map<Integer, Integer> cart = new HashMap<>();
    private final List<Product> products = List.of(
            new Product(1, "Laptop", 50000),
            new Product(2, "Mouse", 500),
            new Product(3, "Keyboard", 1500)
    );

    public List<Product> getProducts() {
        return products;
    }
    
    public Map<Integer, Integer> getCartRaw() {
        return cart;
    }

    public void addToCart(int productId) {
        cart.put(productId, cart.getOrDefault(productId, 0) + 1);
    }

    public Map<Product, Integer> getCartItems() {
        Map<Product, Integer> items = new HashMap<>();
        for (Product p : products) {
            if (cart.containsKey(p.getId())) {
                items.put(p, cart.get(p.getId()));
            }
        }
        return items;
    }
    public void clearCart() {
        cart.clear();
    }

    public double getTotal() {
        return getCartItems().entrySet()
                .stream()
                .mapToDouble(e -> e.getKey().getPrice() * e.getValue())
                .sum();
    }
}
