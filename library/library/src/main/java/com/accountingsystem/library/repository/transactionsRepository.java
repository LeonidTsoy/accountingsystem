package com.accountingsystem.library.repository;

import com.accountingsystem.library.entity.transactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface transactionsRepository extends JpaRepository<transactions, Integer> {
}