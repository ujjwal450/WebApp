package com.ecommerce.WebApp.DTO;

import lombok.Data;

@Data
public class LoginRequest {
    private String identifier;
    private String password;
}
