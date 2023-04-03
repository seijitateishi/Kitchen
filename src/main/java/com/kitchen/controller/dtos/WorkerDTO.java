package com.kitchen.controller.dtos;

import com.kitchen.enums.Office;
import com.kitchen.model.Worker;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
public class WorkerDTO {

    public Long id;

    public String name;

    public String username;

    public Office office;

    public WorkerDTO(Worker worker){
        this.id = worker.getId();
        this.name = worker.getName();
        this.username = worker.getUsername();
        this.office = worker.getOffice();
    }
}
