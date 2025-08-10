package com.ecommerce.WebApp.controller;

import com.ecommerce.WebApp.model.User;
import com.ecommerce.WebApp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getAllUsers();
    }

}
