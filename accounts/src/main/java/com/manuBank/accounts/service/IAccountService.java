package com.manuBank.accounts.service;

import com.manuBank.accounts.dto.CustomerDto;

public interface IAccountService {

    public void createAccount(CustomerDto customerDto);

    public CustomerDto fetchAccount(String mobileNumber);

    public boolean updateAccount(CustomerDto customerDto);

    public boolean deleteAccount(String mobileNumber);
}
