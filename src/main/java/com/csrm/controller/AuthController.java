package com.csrm.controller;

import com.csrm.entity.User;
import com.csrm.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired AuthService service;

    @PostMapping("/register")
    public User register(@RequestBody Map<String, String> body) {
        return service.register(body);
    }

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> body) {
        return service.login(body);
    }
}
