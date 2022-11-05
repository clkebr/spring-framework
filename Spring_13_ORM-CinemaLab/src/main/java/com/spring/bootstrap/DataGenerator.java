package com.spring.bootstrap;

import com.spring.entity.Account;
import com.spring.repository.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DataGenerator implements CommandLineRunner {

    private final AccountRepository accountRepository;

    public DataGenerator(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void run(String... args) throws Exception {



    }
}
