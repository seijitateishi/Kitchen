package com.kitchen.controller;

import com.kitchen.controller.request.EventCreateRequest;
import com.kitchen.model.Event;
import com.kitchen.service.EventService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/event")
@RestController
public class EventController {
    private final EventService eventService;

    @GetMapping("/all")
    public List<Event> findAll() {
        return eventService.findAll();
    }

    @GetMapping("/{id}")
    public Event findById(@PathVariable String id) {
        return eventService.findById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<Void> save(@RequestBody @Valid EventCreateRequest event){
        event.save(eventService);
        return ResponseEntity.status(200).build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        eventService.deleteById(id);
        return ResponseEntity.status(200).build();
    }

    @PostMapping("/{id}/{workerId}")
    public ResponseEntity<Void> addWorker(@PathVariable String id, @PathVariable String workerId) {
        eventService.addWorker(id, workerId);
        return ResponseEntity.status(200).build();
    }
    @PostMapping("/{id}/{guestId}")
    public ResponseEntity<Void> addGuest(@PathVariable String id, @PathVariable String guestId) {
        eventService.addGuest(id, guestId);
        return ResponseEntity.status(200).build();
    }
    @DeleteMapping("/{eventId}/{id}")
    public ResponseEntity<Void> removeFromList(@PathVariable String eventId, @PathVariable String id) {
        eventService.removeFromList(eventId, id);
        return ResponseEntity.status(200).build();
    }
}
