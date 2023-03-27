package com.kitchen.model;

import com.kitchen.enums.Office;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Guest implements java.io.Serializable{
    @Id
    @Column( nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Office office;
    @Column
    private String workerId;
}
