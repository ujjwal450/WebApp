package com.ecommerce.WebApp.DTO;

import lombok.Data;

@Data
public class SignupRequest {
    private String name;
    private String email;
    private String mobile;
    private String password;
}
