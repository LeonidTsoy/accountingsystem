package com.accountingsystem.library.service;

import com.accountingsystem.library.entity.users;
import com.accountingsystem.library.repository.usersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class usersService {

    private final usersRepository userRepository;

    @Autowired
    public usersService(usersRepository userRepository) {
        this.userRepository = userRepository;
    }

    public users findById(Integer userId) {
        return userRepository.getOne(userId);
    }

    public List<users> findAll() {
        return userRepository.findAll();
    }

    public users saveUser(users user) {
        return userRepository.save(user);
    }

    public void deleteById(Integer userId) {
        userRepository.deleteById(userId);
    }
}
