package com.cg.hbm.repository;

import com.cg.hbm.entities.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserDetails, Integer> {
    @Query("select a from UserDetails a where user_name=?1")
    Optional<UserDetails> findUser(String name);
}
