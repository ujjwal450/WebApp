package com.ecommerce.WebApp.service;

import com.ecommerce.WebApp.model.User;
import com.ecommerce.WebApp.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

}
