package com.ecommerce.WebApp.service;

import com.ecommerce.WebApp.DTO.LoginRequest;
import com.ecommerce.WebApp.model.User;
import com.ecommerce.WebApp.repo.UserRepository;
import com.ecommerce.WebApp.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    public String login(LoginRequest loginRequest){

        Optional<User> userOptional = userRepository.findByEmailOrMobile(loginRequest.getIdentifier());
        if (userOptional.isEmpty()){
            throw new RuntimeException("User not found");
        }
        User user = userOptional.get();
        if(!user.getPassword().equals(loginRequest.getPassword())){
            throw new RuntimeException("Invalid Password");
        }
        return jwtUtil.generateToken(user.getEmail());
    }
}
