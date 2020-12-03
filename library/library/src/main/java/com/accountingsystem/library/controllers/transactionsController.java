package com.accountingsystem.library.controllers;

import com.accountingsystem.library.entity.transactions;
import com.accountingsystem.library.service.transactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class transactionsController {

    private final transactionsService transactionsService;

    @Autowired
    public transactionsController(transactionsService transactionsService) {
        this.transactionsService = transactionsService;
    }

    @GetMapping("/transactions")
    public String findAll(Model model){
        List<transactions> transactions = transactionsService.findAll();
        model.addAttribute("transactions", transactions);
        return "transactions-list";
    }

    @GetMapping("/transactions-create")
    public String createTransactionsForm(transactions transactions){
        return "transactions-create";
    }

    @PostMapping("/transactions-create")
    public String createTransactions(transactions transactions){
        transactionsService.saveTransactions(transactions);
        return "redirect:/transactions";
    }

    @GetMapping("transactions-delete/{id}")
    public String deleteTransactions(@PathVariable("id") Integer transactionsId){
        transactionsService.deleteById(transactionsId);
        return "redirect:/transactions";
    }

    @GetMapping("/transactions-update/{id}")
    public String updateTransactionsForm(@PathVariable("id") Integer transactionsId, Model model){
        transactions transactions = transactionsService.findById(transactionsId);
        model.addAttribute("transactions", transactions);
        return "transactions-update";
    }

    @PostMapping("/transactions-update")
    public String updateTransactions(transactions transactions){
        transactionsService.saveTransactions(transactions);
        return "redirect:/transactions";
    }
}