package com.manuBank.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Schema(
        name = "Customer details",
        description = "It has customer details like name, email, mobileNumber "
)
public class CustomerDto {


    @NotEmpty(message="Name cannot be null or empty")
    @Size(min=5, max=30, message="The length of the customer should be between the length of 5 to 30")
    @Schema(
            description = "Name of the customer",
            example = "Manohar Reddy"
    )
    private String name;
    @Email(message="field should be the email format")
    @Schema(
            description = "email of the customer",
            example = "manoharmeda@gmail.com"
    )
    private String email;

    @Pattern(regexp="^[0-9]{10}$", message="Phone number must be exactly 10 digits")
    @Schema(
            description = "mobile number of the customer",
            example = "3144463423"
    )
    private String mobileNumber;
    @Schema(
            description = "account details of the customer"
    )
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
