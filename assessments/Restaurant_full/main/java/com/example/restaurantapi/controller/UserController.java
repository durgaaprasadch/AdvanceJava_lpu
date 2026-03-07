package com.example.restaurantapi.controller;

import com.example.restaurantapi.dto.UserDTO;
import com.example.restaurantapi.entity.User;
import com.example.restaurantapi.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository repo;

    public UserController(UserRepository repo){
        this.repo = repo;
    }

    @PostMapping("/register")
    public String register(@RequestBody UserDTO dto){

        User user = new User();

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setRole(dto.getRole());

        repo.save(user);

        return "User Registered";
    }
}