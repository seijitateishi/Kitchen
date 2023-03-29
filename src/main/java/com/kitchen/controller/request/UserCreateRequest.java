package com.kitchen.controller.request;

import com.kitchen.configuration.security.UserDetailsServiceImpl;
import com.kitchen.enums.Office;
import com.kitchen.enums.TypeOfEvent;
import com.kitchen.model.Event;
import com.kitchen.service.EventService;
import com.kitchen.service.RoleService;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;
import java.util.List;

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
