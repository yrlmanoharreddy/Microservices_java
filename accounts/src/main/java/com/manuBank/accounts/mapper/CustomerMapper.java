package com.manuBank.accounts.mapper;

import com.manuBank.accounts.dto.CustomerDto;
import com.manuBank.accounts.entity.Customer;

public class CustomerMapper {

    public static CustomerDto mapToCustomerDto(Customer cus, CustomerDto cusDto)
    {
        cusDto.setEmail(cus.getEmail());
        cusDto.setMobileNumber(cus.getMobileNumber());
        cusDto.setName(cus.getName());
        return cusDto;
    }

    public static Customer mapToCustomer(Customer cus, CustomerDto cusDto)
    {
        cus.setEmail(cusDto.getEmail());
        cus.setMobileNumber(cusDto.getMobileNumber());
        cus.setName(cusDto.getName());

        return cus;
    }

}
