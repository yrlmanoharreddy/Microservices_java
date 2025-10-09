package com.manuBank.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;


@Schema(
        name = "Account class",
        description = "Schema to hold the Account details"
)
public class AccountsDto {

    @NotEmpty(message="Account number cannot be null or empty")
    @Pattern(regexp = "^[0-9]{10}$", message="The account must contain 10 digits ")
    private Long AccountNumber;

    @NotEmpty
    @Schema(
            description = "Type of account whether it is SAVINGS/CHECKING"
    )
    private String AccountType;
    private String branchAddress;
    private CustomerDto customerDto;

    public AccountsDto()
    {

    }

    public AccountsDto(Long accountNumber, String accountType, String branchAddress, CustomerDto customerDto) {
        AccountNumber = accountNumber;
        AccountType = accountType;
        this.branchAddress = branchAddress;
        this.customerDto = customerDto;
    }

    public CustomerDto getCustomerDto() {
        return customerDto;
    }

    public void setCustomerDto(CustomerDto customerDto) {
        this.customerDto = customerDto;
    }

    public String getAccountType() {
        return AccountType;
    }

    public void setAccountType(String accountType) {
        AccountType = accountType;
    }

    public Long getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        AccountNumber = accountNumber;
    }

    public String getBranchAddress() {
        return branchAddress;
    }

    public void setBranchAddress(String branchAddress) {
        this.branchAddress = branchAddress;
    }

    @Override
    public String toString() {
        return "AccountsDto{" +
                "AccountNumber=" + AccountNumber +
                ", AccountType='" + AccountType + '\'' +
                ", branchAddress='" + branchAddress + '\'' +
                '}';
    }
}
