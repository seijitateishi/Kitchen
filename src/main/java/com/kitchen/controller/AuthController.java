package com.kitchen.controller;

import com.kitchen.configuration.security.UserDetailsServiceImpl;
import com.kitchen.controller.request.UserCreateRequest;
import com.kitchen.enums.Office;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/auth")
@RestController
public class AuthController {
    final UserDetailsServiceImpl userDetailsService;
    @PostMapping("/register")
    public void register(@RequestBody @Valid UserCreateRequest userCreateRequest) {
        userCreateRequest.save(userDetailsService);
    }
    @PostMapping("/login/{username}/{password}")
    public void login(@PathVariable String username, @PathVariable String password) {
        userDetailsService.loadUserByUsername(username);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}/{office}")
    public void update(@PathVariable Long id, @PathVariable Office office) {
        userDetailsService.update(id, office);
    }
}