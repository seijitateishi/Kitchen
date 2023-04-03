package com.kitchen.controller.dtos;

import com.kitchen.model.Guest;
import lombok.Getter;

@Getter
public class GuestDTO {

    public Long id;

    public String name;

    public Long workerId;

    GuestDTO(Guest guest) {
        this.id = guest.getId();
        this.name = guest.getName();
        this.workerId = guest.getWorkerId();
    }
}
