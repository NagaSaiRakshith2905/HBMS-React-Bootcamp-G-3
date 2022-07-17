package com.cg.hbm.repository;

import com.cg.hbm.entities.RoomDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RoomDetailsRepository extends JpaRepository<RoomDetails,Integer> {


    @Query("select r from RoomDetails r where room_id=?1")
    Optional<RoomDetails> findbyId(Integer integer);
}
