package com.spring.controller;

import com.spring.entity.Account;
import com.spring.entity.User;
import com.spring.repository.AccountRepository;
import com.spring.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class HomeController {

    private UserRepository userRepository;
    private AccountRepository accountRepository;

    public HomeController(UserRepository userRepository, AccountRepository accountRepository) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
    }

    @GetMapping("/users")
    public List<User> readAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/accounts")
    public List<Account> readAllAccounts(){
        return accountRepository.findAll();
    }
}