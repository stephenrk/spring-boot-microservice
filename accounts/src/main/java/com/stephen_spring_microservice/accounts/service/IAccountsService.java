package com.stephen_spring_microservice.accounts.service;

import com.stephen_spring_microservice.accounts.dto.CustomerDto;

public interface IAccountsService {

    /**
     * Create a new account for a customer
     * @param customerDto
     */
    void createAccount(CustomerDto customerDto);
}
