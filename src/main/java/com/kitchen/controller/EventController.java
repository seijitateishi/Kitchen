package com.kitchen.controller;

import com.kitchen.controller.dtos.EventDTO;
import com.kitchen.controller.request.EventCreateRequest;
import com.kitchen.service.EventService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/event")
@RestController
public class EventController {
    private final EventService eventService;


    //GET
    @GetMapping("/all")
    public List<EventDTO> findAll() {
        return eventService.findAll();
    }

    @GetMapping("/{id}")
    public EventDTO findById(@PathVariable Long id) {
        return eventService.findByIdDTO(id);
    }

    //POST
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<Void> save(@RequestBody @Valid EventCreateRequest event){
        event.save(eventService);
        return ResponseEntity.status(200).build();
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'WORKER')")
    @PostMapping("/worker/{eventId}/{workerId}")
    public ResponseEntity<Void> addWorker(@PathVariable Long eventId, @PathVariable Long workerId) {
        eventService.addWorker(eventId, workerId);
        return ResponseEntity.status(200).build();
    }
    @PreAuthorize("hasAnyRole('ADMIN', 'WORKER')")
    @PostMapping("/guest/{id}/{guestId}")
    public ResponseEntity<Void> addGuest(@PathVariable Long id, @PathVariable Long guestId) {
        eventService.addGuest(id, guestId);
        return ResponseEntity.status(200).build();
    }

    //DELETE
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        eventService.deleteById(id);
        return ResponseEntity.status(200).build();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{eventId}/{id}")
    public ResponseEntity<Void> removeFromList(@PathVariable Long eventId, @PathVariable Long id) {
        eventService.removeFromList(eventId, id);
        return ResponseEntity.status(200).build();
    }

    //PUT
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{eventId}/{description}")
    public ResponseEntity<Void> updateDescription(@PathVariable Long eventId, @PathVariable String description) {
        eventService.updateDescription(eventId, description);
        return ResponseEntity.status(200).build();
    }
}
