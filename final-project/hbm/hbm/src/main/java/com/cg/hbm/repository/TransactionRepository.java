package com.cg.hbm.repository;

import com.cg.hbm.entities.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TransactionRepository extends JpaRepository<Transactions,Integer> {
}
