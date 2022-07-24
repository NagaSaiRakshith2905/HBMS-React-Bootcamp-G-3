package com.cg.hbm.repository;

import com.cg.hbm.entities.Payments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payments,Integer> {
}
