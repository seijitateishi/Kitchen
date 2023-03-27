package com.kitchen.model;

import com.kitchen.enums.TypeOfEvent;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Event implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private String id;
    private String description;
    private LocalDateTime listLimitTime;
    private LocalDateTime eventTime;
    @OneToMany
    private List<Worker> workerList;
    @OneToMany
    private List<Guest> guestList;

    @Column(nullable = false)
    private TypeOfEvent typeOfEvent;
}
