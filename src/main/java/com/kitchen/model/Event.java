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
    private String description;
    private LocalDateTime listLimitTime;
    private LocalDateTime eventTime;
    @ManyToMany
    private List<Worker> workerList;
    @ManyToMany
    private List<Guest> guestList;
    @Column(nullable = false)
    private TypeOfEvent typeOfEvent;
}
