package com.stephen_spring_microservice.accounts.dto;

import lombok.Data;

@Data
public class AccountsDto {

    private Long accountNumber;

    private String accountType;

    private String branchAddress;
}
