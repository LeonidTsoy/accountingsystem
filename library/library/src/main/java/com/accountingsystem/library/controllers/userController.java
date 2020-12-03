package com.accountingsystem.library.controllers;

import com.accountingsystem.library.entity.users;
import com.accountingsystem.library.service.usersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class userController {

    private final usersService usersService;

    @Autowired
    public userController(usersService userService) {
        this.usersService = userService;
    }

    @GetMapping("/users")
    public String findAll(Model model){
        List<users> users = usersService.findAll();
        model.addAttribute("users", users);
        return "user-list";
    }

    @GetMapping("/user-create")
    public String createUserForm(users user){
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(users user){
        usersService.saveUser(user);
        return "users";
    }

    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") Integer userId){
        usersService.deleteById(userId);
        return "users";
    }

    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") Integer userId, Model model){
        users user = usersService.findById(userId);
        model.addAttribute("user", user);
        return "user-update";
    }

    @PostMapping("/user-update")
    public String updateUser(users user){
        usersService.saveUser(user);
        return "users";
    }
}
