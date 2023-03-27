package com.kitchen.model;

import com.kitchen.enums.Office;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Worker implements java.io.Serializable{
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Office office;
}
