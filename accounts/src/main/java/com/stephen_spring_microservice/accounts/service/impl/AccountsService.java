package com.stephen_spring_microservice.accounts.service.impl;

import org.springframework.stereotype.Service;

import com.stephen_spring_microservice.accounts.dto.CustomerDto;
import com.stephen_spring_microservice.accounts.repository.AccountsRepository;
import com.stephen_spring_microservice.accounts.repository.CustomerRepository;
import com.stephen_spring_microservice.accounts.service.IAccountsService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AccountsService implements IAccountsService {

    private final CustomerRepository customerRepository;
    private final AccountsRepository accountsRepository;

    @Override
    public void createAccount(CustomerDto customerDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createAccount'");
    }

}
