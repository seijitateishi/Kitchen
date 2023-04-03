package com.kitchen.model;

import com.kitchen.enums.Office;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
@AllArgsConstructor
@Builder
@Setter
@Getter
@Entity
@NoArgsConstructor
public class Role implements GrantedAuthority, Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Office office;

    @Override
    public String getAuthority() {
        return this.office.toString();
    }
}
