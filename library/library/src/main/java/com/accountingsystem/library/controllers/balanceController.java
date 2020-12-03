package com.accountingsystem.library.controllers;

import com.accountingsystem.library.entity.balance;
import com.accountingsystem.library.service.balanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class balanceController {

    private final balanceService balanceService;

    @Autowired
    public balanceController(balanceService balanceService) {
        this.balanceService = balanceService;
    }

    @GetMapping("/balance")
    public String findAll(Model model){
        List<balance> balance = balanceService.findAll();
        model.addAttribute("balance", balance);
        return "balance-list";
    }

    @GetMapping("/user-create")
    public String createBalanceForm(balance balance){
        return "balance-create";
    }

    @PostMapping("/balance-create")
    public String createBalance(balance balance){
        balanceService.saveBalance(balance);
        return "redirect:/balance";
    }

    @GetMapping("balance-delete/{id}")
    public String deleteBalance(@PathVariable("id") Integer balanceId){
        balanceService.deleteById(balanceId);
        return "redirect:/balance";
    }

    @GetMapping("/balance-update/{id}")
    public String updateBalanceForm(@PathVariable("id") Integer balanceId, Model model){
        balance balance = balanceService.findById(balanceId);
        model.addAttribute("balance", balance);
        return "balance-update";
    }

    @PostMapping("/balance-update")
    public String updateBalance(balance balance){
        balanceService.saveBalance(balance);
        return "redirect:/balance";
    }
}