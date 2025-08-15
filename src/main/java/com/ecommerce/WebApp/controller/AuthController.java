package com.ecommerce.WebApp.controller;

import com.ecommerce.WebApp.DTO.LoginRequest;
import com.ecommerce.WebApp.DTO.SignupRequest;
import com.ecommerce.WebApp.model.User;
import com.ecommerce.WebApp.service.LoginService;
import com.ecommerce.WebApp.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final LoginService loginService;
    private final RegisterService registerService;


    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody SignupRequest dto) {
        User user = registerService.registerUser(dto);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginRequest dto) {
        String token = loginService.login(dto);
        Map<String, String> response = new HashMap<String, String>();
        response.put("token", token);

        return ResponseEntity.ok(response);
    }

}
