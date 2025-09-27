package com.manuBank.accounts.service.impl;

import com.manuBank.accounts.constants.AccountConstants;
import com.manuBank.accounts.dto.CustomerDto;
import com.manuBank.accounts.entity.Accounts;
import com.manuBank.accounts.entity.Customer;
import com.manuBank.accounts.exception.CustomerAlreadyExistsException;
import com.manuBank.accounts.mapper.CustomerMapper;
import com.manuBank.accounts.repository.AccountsRepository;
import com.manuBank.accounts.repository.CustomerRepository;
import com.manuBank.accounts.service.IAccountService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class AccountServiceImpl implements IAccountService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;

    public AccountServiceImpl(AccountsRepository accountsRepository, CustomerRepository customerRepository) {
        this.accountsRepository = accountsRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void createAccount(CustomerDto customerDto)
    {
        Customer customer = CustomerMapper.mapToCustomer(new Customer(), customerDto);
        Optional<Customer> optionalCustomer = customerRepository.findByMobileNumber(customer.getMobileNumber());

        if(optionalCustomer.isPresent())
        {
            throw new CustomerAlreadyExistsException("Customer Alreay Exists with the given mobile Number " +
                    customerDto.getMobileNumber());
        }
        Customer savedCus = customerRepository.save(customer);
        accountsRepository.save(createNewAccount(savedCus));
    }

    private Accounts createNewAccount(Customer customer) {
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        Long accNo = 100000L + (new Random()).nextInt(900000);
        newAccount.setAccountNumber(accNo);
        newAccount.setBranchAddress(AccountConstants.ADDRESS);
        newAccount.setAccountType(AccountConstants.SAVINGS);
        return newAccount;
    }
}
