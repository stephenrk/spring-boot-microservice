package com.stephen_spring_microservice.accounts.service.impl;

import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.stephen_spring_microservice.accounts.constants.AccountsConstants;
import com.stephen_spring_microservice.accounts.dto.CustomerDto;
import com.stephen_spring_microservice.accounts.entity.Customer;
import com.stephen_spring_microservice.accounts.exception.CustomerAlreadyExistException;
import com.stephen_spring_microservice.accounts.entity.Accounts;
import com.stephen_spring_microservice.accounts.repository.AccountsRepository;
import com.stephen_spring_microservice.accounts.repository.CustomerRepository;
import com.stephen_spring_microservice.accounts.service.IAccountsService;
import com.stephen_spring_microservice.accounts.mapper.CustomerMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AccountsService implements IAccountsService {

    private final CustomerRepository customerRepository;
    private final AccountsRepository accountsRepository;

    @Override
    public void createAccount(CustomerDto customerDto) {
        Customer customer = CustomerMapper.mapToCustomer(customerDto, new Customer());
        customerRepository.findByMobileNumber(customer.getMobileNumber()).ifPresent(c -> {
            throw new CustomerAlreadyExistException("Customer already exists with mobile number: " + customer.getMobileNumber());
        });
        customer.setCreatedAt(LocalDateTime.now());
        customer.setCreatedBy(customer.getEmail());
        Customer savedCustomer = customerRepository.save(customer);
        accountsRepository.save(createNewAccount(savedCustomer));

    }

    private Accounts createNewAccount(Customer customer) {
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);

        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(AccountsConstants.SAVINGS);
        newAccount.setBranchAddress(AccountsConstants.ADDRESS);
        newAccount.setCreatedAt(LocalDateTime.now());
        newAccount.setCreatedBy(customer.getEmail());
        return newAccount;
    }

}
