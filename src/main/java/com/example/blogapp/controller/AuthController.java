package com.example.blogapp.controller;

import com.example.blogapp.dto.LoginRequest;
import com.example.blogapp.dto.RegisterRequest;
import com.example.blogapp.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {
    @Autowired
    private AuthService authService;
    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody  RegisterRequest registerRequest){
        authService.signUp(registerRequest);
        return new ResponseEntity(HttpStatus.OK);
    }
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest){
        return authService.login(loginRequest);
    }
}
