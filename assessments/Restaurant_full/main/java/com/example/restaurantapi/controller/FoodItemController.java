package com.example.restaurantapi.controller;

import com.example.restaurantapi.dto.FoodItemDTO;
import com.example.restaurantapi.entity.FoodItem;
import com.example.restaurantapi.repository.FoodItemRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
public class FoodItemController {

    private final FoodItemRepository repo;

    public FoodItemController(FoodItemRepository repo){
        this.repo = repo;
    }

    @PostMapping("/{restaurantId}/fooditems")
    public FoodItem addFood(@PathVariable Long restaurantId,@RequestBody FoodItemDTO dto){

        FoodItem item = new FoodItem();

        item.setName(dto.getName());
        item.setPrice(dto.getPrice());
        item.setCategory(dto.getCategory());
        item.setRestaurantId(restaurantId);

        return repo.save(item);
    }

    @GetMapping("/{restaurantId}/fooditems")
    public List<FoodItem> getFoodItems(@PathVariable Long restaurantId){

        return repo.findByRestaurantId(restaurantId);
    }
}