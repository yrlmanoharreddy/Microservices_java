package com.manuBank.accounts.dto;

public class AccountsDto {

    private Long AccountNumber;
    private String AccountType;
    private String branchAddress;

    public AccountsDto()
    {

    }

    public AccountsDto(String branchAddress, String accountType, Long accountNumber) {
        this.branchAddress = branchAddress;
        AccountType = accountType;
        AccountNumber = accountNumber;
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
