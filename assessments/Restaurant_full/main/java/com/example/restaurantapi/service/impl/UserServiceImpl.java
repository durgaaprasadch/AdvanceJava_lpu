
package com.example.restaurantapi.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.restaurantapi.dto.UserDTO;
import com.example.restaurantapi.entity.User;
import com.example.restaurantapi.repository.UserRepository;
import com.example.restaurantapi.service.UserService;

@Service
public class UserServiceImpl implements UserService{

private final UserRepository repo;
private final PasswordEncoder encoder;

public UserServiceImpl(UserRepository repo,PasswordEncoder encoder){
this.repo=repo;
this.encoder=encoder;
}

public void register(UserDTO dto){
User u=new User();
u.setName(dto.getName());
u.setEmail(dto.getEmail());
u.setPassword(encoder.encode(dto.getPassword()));
u.setRole(dto.getRole());
repo.save(u);
}
}
