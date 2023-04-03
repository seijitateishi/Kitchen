package com.kitchen.service;

import com.kitchen.controller.dtos.EventDTO;
import com.kitchen.model.Event;
import com.kitchen.model.Guest;
import com.kitchen.model.Worker;
import com.kitchen.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class EventService {
    private final GuestService guestService;
    private final WorkerService workerService;
    private final EventRepository eventRepository;

    public List<EventDTO> findAll() {
        return eventRepository.findAll().stream().map(EventDTO::new).toList();
    }

    /*public List<Event> findAll() {
        return eventRepository.findAll();
    }*/

    public EventDTO findByIdDTO(Long id) {
        return new EventDTO(Objects.requireNonNull(eventRepository.findById(id).orElse(null)));
    }

    public Event findById(Long id) {
        return eventRepository.findById(id).orElse(null);
    }

    public Event save(Event event) {
        return eventRepository.save(event);
    }

    public void deleteById(Long id) {
        eventRepository.deleteById(id);
    }

    public void addWorker(Long EventId, Long workerId) {
        if (LocalDateTime.now().isAfter(findById(EventId).getListLimitTime())){
            System.out.println("teste3");
            throw new RuntimeException("Tempo limite para adicionar funcionarios expirado!");
        }
        System.out.println("teste4");
        Event event = eventRepository.findById(EventId).orElseThrow(() -> new RuntimeException("Evento não encontrado!"));
        System.out.println("teste5");
        Worker worker = workerService.findById(workerId);
        if(worker != null && event != null) {
            event.getWorkerList().add(worker);
            save(event);
            System.out.println("teste1");
        }
        System.out.println("teste2");
    }

    public void addGuest(Long EventId, Long guestId) {
        if (LocalDateTime.now().isAfter(findById(EventId).getListLimitTime()))
            throw new RuntimeException("Tempo limite para adicionar convidados expirado!");
        Event event = findById(EventId);
        Guest guest = guestService.findById(guestId);
        if(guest != null && event != null) {
            event.getGuestList().add(guest);
            save(event);
        }
    }

    public void removeFromList(Long EventId, Long id) {
        Event event = findById(EventId);
        if(event != null) {
            event.getGuestList().removeIf(guest -> guest.getId().equals(id));
            event.getWorkerList().removeIf(worker -> worker.getId().equals(id));
            save(event);
        }
    }

    public void updateDescription(Long eventId, String description) throws RuntimeException{
        Event event = findById(eventId);
        if (event == null)
            throw new RuntimeException("Evento não encontrado!");
        event.setDescription(description);
        save(event);
    }
}
