package com.kitchen.service;

import com.kitchen.enums.Office;
import com.kitchen.model.Role;
import com.kitchen.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RoleService {
    final RoleRepository roleRepository;

    public void save(Role role) {
        roleRepository.save(role);
    }

    public Role findById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        roleRepository.deleteById(id);
    }

    public Iterable<Role> findAll() {
        return roleRepository.findAll();
    }

    public Role findByOffice(Office office){
        return roleRepository.findByOffice(office);
    }

}
