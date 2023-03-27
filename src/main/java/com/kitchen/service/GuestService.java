package com.kitchen.service;

import com.kitchen.model.Guest;
import lombok.RequiredArgsConstructor;
import com.kitchen.repository.GuestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GuestService {
    private final GuestRepository guestRepository;

    public List<Guest> findAll() {
        return guestRepository.findAll();
    }

    public Guest findById(String id) {
        return guestRepository.findById(id).orElse(null);
    }

    public Guest save(Guest guest) {
        return guestRepository.save(guest);
    }

    public void deleteById(String id) {
        guestRepository.deleteById(id);
    }
}
