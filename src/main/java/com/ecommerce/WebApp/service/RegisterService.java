package com.ecommerce.WebApp.service;

import com.ecommerce.WebApp.DTO.SignupRequest;
import com.ecommerce.WebApp.model.User;
import com.ecommerce.WebApp.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterService {
    private final UserRepository userRepository;
    public User registerUser(SignupRequest signupRequest){
        User user = new User();
        user.setName(signupRequest.getName());
        user.setEmail(signupRequest.getEmail());
        user.setMobile(signupRequest.getMobile());
        user.setPassword(signupRequest.getPassword());
        if (userRepository.existsByEmailOrMobile(signupRequest.getEmail()) ||
                userRepository.existsByEmailOrMobile(signupRequest.getMobile())) {
            throw new RuntimeException("User already exists");
        }
        return userRepository.save(user);

    }
}
