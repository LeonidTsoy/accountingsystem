package com.accountingsystem.library.repository;

import com.accountingsystem.library.entity.users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface usersRepository extends JpaRepository<users, Integer> {
}