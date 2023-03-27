package com.kitchen.service;

import com.kitchen.model.Event;
import com.kitchen.model.Guest;
import com.kitchen.model.Worker;
import com.kitchen.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {
    private final GuestService guestService;
    private final WorkerService workerService;
    private final EventRepository eventRepository;
    public List<Event> findAll() {
        return eventRepository.findAll();
    }
    public Event findById(String id) {
        return eventRepository.findById(id).orElse(null);
    }

    public Event save(Event event) {
        return eventRepository.save(event);
    }
    public void deleteById(String id) {
        eventRepository.deleteById(id);
    }
    public void addWorker(String EventId, String workerId) {
        Event event = findById(EventId);
        Worker worker = workerService.findById(workerId);
        if(worker != null && event != null) {
            event.getWorkerList().add(worker);
            save(event);
        }
    }
    public void addGuest(String EventId, String guestId) {
        Event event = findById(EventId);
        Guest guest = guestService.findById(guestId);
        if(guest != null && event != null) {
            event.getGuestList().add(guest);
            save(event);
        }
    }

    public void removeFromList(String EventId, String id) {
        Event event = findById(EventId);
        if(event != null) {
            event.getGuestList().removeIf(guest -> guest.getId().equals(id));
            event.getWorkerList().removeIf(worker -> worker.getId().equals(id));
            save(event);
        }
    }
}
