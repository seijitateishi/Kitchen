package com.kitchen.repository;
import com.kitchen.enums.Office;
import com.kitchen.model.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByOffice(Office office);
}