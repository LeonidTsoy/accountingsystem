package com.accountingsystem.library.service;

import com.accountingsystem.library.entity.transactions;
import com.accountingsystem.library.repository.transactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class transactionsService {

    private final transactionsRepository transactionsRepository;

    @Autowired
    public transactionsService(transactionsRepository transactionsRepository) {
        this.transactionsRepository = transactionsRepository;
    }

    public transactions findById(Integer transactionsId) {
        return transactionsRepository.getOne(transactionsId);
    }

    public List<transactions> findAll() {
        return transactionsRepository.findAll();
    }

    public transactions saveTransactions(transactions transactions) {
        return transactionsRepository.save(transactions);
    }

    public void deleteById(Integer transactionsId) {
        transactionsRepository.deleteById(transactionsId);
    }
}
