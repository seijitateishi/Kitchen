package com.kitchen.model;

import com.kitchen.enums.TypeOfEvent;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Event implements java.io.Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private LocalDateTime listLimitTime;

    @Column(nullable = false)
    private LocalDateTime eventTime;

    @ManyToMany
    @Column
    private List<Worker> workerList;

    @ManyToMany
    @Column
    private List<Guest> guestList;

    @Column(nullable = false)
    private TypeOfEvent typeOfEvent;
}
