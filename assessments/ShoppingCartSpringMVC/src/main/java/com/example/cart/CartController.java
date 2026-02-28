
package com.example.cart;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CartController {

    private final CartService service;

    public CartController(CartService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String products(Model model) {
        model.addAttribute("products", service.getProducts());
        model.addAttribute("cartQuantities", service.getCartRaw());
        return "products";
    }

    @PostMapping("/add")
    public String add(@RequestParam("id") int id, Model model) {

        service.addToCart(id);
        
        model.addAttribute("products", service.getProducts());
        model.addAttribute("cartQuantities", service.getCartRaw());

        return "products";
    }
    @PostMapping("/reset")
    public String resetCart() {
        service.clearCart();
        return "redirect:/";
    }

    @GetMapping("/cart")
    public String cart(Model model) {
        model.addAttribute("items", service.getCartItems());
        model.addAttribute("total", service.getTotal());
        return "cart";
    }
}
