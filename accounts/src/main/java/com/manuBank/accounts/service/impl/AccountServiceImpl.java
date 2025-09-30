package com.manuBank.accounts.service.impl;

import com.manuBank.accounts.constants.AccountConstants;
import com.manuBank.accounts.dto.AccountsDto;
import com.manuBank.accounts.dto.CustomerDto;
import com.manuBank.accounts.entity.Accounts;
import com.manuBank.accounts.entity.Customer;
import com.manuBank.accounts.exception.CustomerAlreadyExistsException;
import com.manuBank.accounts.exception.ResourceNotFoundException;
import com.manuBank.accounts.mapper.AccountsMapper;
import com.manuBank.accounts.mapper.CustomerMapper;
import com.manuBank.accounts.repository.AccountsRepository;
import com.manuBank.accounts.repository.CustomerRepository;
import com.manuBank.accounts.service.IAccountService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;
import java.util.Random;

import static com.manuBank.accounts.mapper.CustomerMapper.mapToCustomer;

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
        Customer customer = mapToCustomer(new Customer(), customerDto);
        Optional<Customer> optionalCustomer = customerRepository.findByMobileNumber(customer.getMobileNumber());

        if(optionalCustomer.isPresent())
        {
            throw new CustomerAlreadyExistsException("Customer Already Exists with the given mobile Number " +
                    customerDto.getMobileNumber());
        }
        customer.setCreatedAt(new Date());
        customer.setCreatedBy("YRLManohar");
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
        newAccount.setCreatedAt(new Date());
        newAccount.setCreatedBy("YrlToo");
        return newAccount;
    }

    @Override
    public CustomerDto fetchAccount(String mobileNumber)
    {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("customer", "mobilenumber", mobileNumber)
        );
        CustomerDto customerDto = CustomerMapper.mapToCustomerDto(customer, new CustomerDto());

        Accounts account = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                ()-> new ResourceNotFoundException("account", "customerId", customer.getCustomerId().toString())
        );
        customerDto.setAccountsDto(AccountsMapper.mapToAccountsDto(account, new AccountsDto()));
        return customerDto;
    }


    @Override
    public boolean updateAccount(CustomerDto customerDto)
    {
        boolean isUpdated = false;
        AccountsDto accountsDto = customerDto.getAccountsDto();
        if(accountsDto!=null)
        {
            Accounts account = accountsRepository.findById(accountsDto.getAccountNumber()).orElseThrow(
                    ()-> new ResourceNotFoundException("account", "accountNumber", accountsDto.getAccountNumber().toString())
            );

            account = AccountsMapper.mapToAccounts(account, accountsDto);
            accountsRepository.save(account);

            Integer customerId = account.getCustomerId();
            Customer customer = customerRepository.findById(customerId).orElseThrow(
                    ()-> new ResourceNotFoundException("customer", "customerId", customerId.toString())
            );

            customer = CustomerMapper.mapToCustomer(customer, customerDto);
            customerRepository.save(customer);

            isUpdated = true;
        }
        return isUpdated;
    }

    @Override
    public boolean deleteAccount(String mobileNumber)
    {
        boolean isDeleted = false;
        if(!isDeleted)
        {
            Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                    ()-> new ResourceNotFoundException("customer", "mobilenumber", mobileNumber)
            );

            accountsRepository.deleteByCustomerId(customer.getCustomerId());
            customerRepository.deleteById(customer.getCustomerId());
            isDeleted = true;
            System.out.println("mob "+mobileNumber);
        }
        return isDeleted;
    }


}
