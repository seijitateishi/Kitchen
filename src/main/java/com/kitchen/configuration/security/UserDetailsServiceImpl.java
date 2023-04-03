package com.kitchen.configuration.security;

import com.kitchen.enums.Office;
import com.kitchen.model.Worker;
import com.kitchen.repository.WorkerRepository;
import com.kitchen.service.RoleService;
import jakarta.transaction.Transactional;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    final RoleService roleService;

    final WorkerRepository workerRepository;

    public UserDetailsServiceImpl(RoleService roleService, WorkerRepository workerRepository) {
        this.roleService = roleService;
        this.workerRepository = workerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Worker worker = workerRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new User(worker.getUsername(), worker.getPassword(), worker.getAuthorities() );
    }

    public void register(String name, String username, Office role, String password) {
        Worker worker = Worker.builder()
                .name(name)
                .username(username)
                .office(role)
                .password(password)
                .roles(List.of(roleService.findByOffice(role)))
                .build();
        workerRepository.save(worker);
    }

    public void update(Long id, Office office) {
        Worker worker = workerRepository.findById(id).orElse(null);
        assert worker != null;
        worker.setOffice(office);
        worker.getRoles().add(roleService.findByOffice(office));
        workerRepository.save(worker);
    }
}