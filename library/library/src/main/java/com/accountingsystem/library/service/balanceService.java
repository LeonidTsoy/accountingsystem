package com.accountingsystem.library.service;

import com.accountingsystem.library.entity.balance;
import com.accountingsystem.library.repository.balanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class balanceService {

    private final balanceRepository balanceRepository;

    @Autowired
    public balanceService(balanceRepository balanceRepository) {
        this.balanceRepository = balanceRepository;
    }

    public balance findById(Integer balanceId) {
        return balanceRepository.getOne(balanceId);
    }

    public List<balance> findAll() {
        return balanceRepository.findAll();
    }

    public balance saveBalance(balance balance) {
        return balanceRepository.save(balance);
    }

    public void deleteById(Integer balanceId) {
        balanceRepository.deleteById(balanceId);
    }
}
