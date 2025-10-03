package com.manuBank.accounts.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class CustomerDto {


    @NotEmpty(message="Name cannot be null or empty")
    @Size(min=5, max=30, message="The length of the customer should be between the length of 5 to 30")
    private String name;
    @Email(message="field should be the email format")
    private String email;

    @Pattern(regexp="^[0-9]{10}$", message="Phone number must be exactly 10 digits")
    private String mobileNumber;
    private AccountsDto accountsDto;

    public CustomerDto()
    {

    }

    public CustomerDto(String name, String email, String mobileNumber, AccountsDto accountsDto) {
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.accountsDto = accountsDto;
    }

    public AccountsDto getAccountsDto() {
        return accountsDto;
    }

    public void setAccountsDto(AccountsDto accountsDto) {
        this.accountsDto = accountsDto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        return "CustomerDto{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                '}';
    }
}
