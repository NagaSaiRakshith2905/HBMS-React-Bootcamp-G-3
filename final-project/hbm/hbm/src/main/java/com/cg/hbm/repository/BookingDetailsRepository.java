package com.cg.hbm.repository;

import com.cg.hbm.entities.BookingDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingDetailsRepository extends JpaRepository<BookingDetails,Integer> {
}
