package com.kitchen.controller.request;

import com.kitchen.configuration.security.UserDetailsServiceImpl;
import com.kitchen.enums.Office;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Data
public class UserCreateRequest {//name,username,role.password,authorities

    @NotNull
    @Size(min = 3, max = 50)
    private String name;

    @NotNull
    private String username;

    @NotNull
    private String password;

    public void save(UserDetailsServiceImpl userDetailsService) {
        userDetailsService.register(name, username, Office.ROLE_WORKER, new BCryptPasswordEncoder().encode(password));
    }

}
