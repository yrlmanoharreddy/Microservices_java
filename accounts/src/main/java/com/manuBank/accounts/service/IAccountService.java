package com.manuBank.accounts.service;

import com.manuBank.accounts.dto.CustomerDto;

public interface IAccountService {

    void createAccount(CustomerDto customerDto);
}
