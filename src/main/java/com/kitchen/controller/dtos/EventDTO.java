package com.kitchen.controller.dtos;

import com.kitchen.enums.TypeOfEvent;
import com.kitchen.model.Event;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class EventDTO {

    private Long id;

    private String description;

    private LocalDateTime listLimitTime;

    private LocalDateTime eventTime;

    private TypeOfEvent typeOfEvent;

    private List<WorkerDTO> workers;

    private List<GuestDTO> guests;

    public EventDTO(Event event){
        this.id = event.getId();
        this.description = event.getDescription();
        this.listLimitTime = event.getListLimitTime();
        this.eventTime = event.getEventTime();
        this.typeOfEvent = event.getTypeOfEvent();
        this.workers = event.getWorkerList().stream().map(WorkerDTO::new).toList();
        this.guests = event.getGuestList().stream().map(GuestDTO::new).toList();
    }

}
