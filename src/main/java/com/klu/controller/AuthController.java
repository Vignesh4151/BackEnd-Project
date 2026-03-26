package com.klu.controller;
import com.klu.model.User;
import com.klu.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
//@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // Signup
    @PostMapping("/signup")
    public User register(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
  
    public ResponseEntity<?> login(@RequestBody User request) {
        User user = userService.login(request.getEmail(), request.getPassword());

        if (user == null) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }

        return ResponseEntity.ok(user);
    }
}
