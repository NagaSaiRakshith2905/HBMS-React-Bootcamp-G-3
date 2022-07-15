package com.cg.hbm.repository;

import com.cg.hbm.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin,Integer> {
    Optional<Admin> findByAdmin_name(String admin_name);
}
