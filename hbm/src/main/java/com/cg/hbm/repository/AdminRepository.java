package com.cg.hbm.repository;

import com.cg.hbm.entities.Admin;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin,Integer> {

    @Query("select a from Admin a where admin_name=?1")
    Admin findByAdmin_name(String name);
}
