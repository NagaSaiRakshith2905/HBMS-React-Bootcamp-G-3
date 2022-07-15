package com.cg.hbm.repository;

import com.cg.hbm.entities.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDetails,Integer> {
}
