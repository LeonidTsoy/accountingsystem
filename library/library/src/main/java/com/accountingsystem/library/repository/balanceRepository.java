package com.accountingsystem.library.repository;

import com.accountingsystem.library.entity.balance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface balanceRepository extends JpaRepository<balance, Integer> {
}