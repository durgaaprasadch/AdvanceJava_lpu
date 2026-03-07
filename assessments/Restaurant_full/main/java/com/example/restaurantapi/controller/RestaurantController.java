package com.example.restaurantapi.controller;

import com.example.restaurantapi.dto.RestaurantDTO;
import com.example.restaurantapi.entity.Restaurant;
import com.example.restaurantapi.repository.RestaurantRepository;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    private final RestaurantRepository repo;

    public RestaurantController(RestaurantRepository repo){
        this.repo = repo;
    }

    @PostMapping
    public Restaurant addRestaurant(@RequestBody RestaurantDTO dto){

        Restaurant r = new Restaurant();

        r.setName(dto.getName());
        r.setLocation(dto.getLocation());
        r.setRating(dto.getRating());

        return repo.save(r);
    }

    @GetMapping
    public Page<Restaurant> getRestaurants(@RequestParam int page,@RequestParam int size){

        return repo.findAll(PageRequest.of(page,size));
    }
}