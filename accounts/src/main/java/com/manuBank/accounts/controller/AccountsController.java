package com.manuBank.accounts.controller;

import com.manuBank.accounts.constants.AccountConstants;
import com.manuBank.accounts.dto.AccountsDto;
import com.manuBank.accounts.dto.CustomerDto;
import com.manuBank.accounts.dto.ResponseDto;
import com.manuBank.accounts.service.impl.AccountServiceImpl;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api")
@Validated
public class AccountsController {

    private AccountServiceImpl accountserviceImp;

    public AccountsController(AccountServiceImpl accountserviceImp) {
        this.accountserviceImp = accountserviceImp;
    }

    @PostMapping(value = "/create", consumes="application/json")
    public ResponseEntity<ResponseDto> createAccount(@Valid @RequestBody CustomerDto customerDto) {

        accountserviceImp.createAccount(customerDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountConstants.STATUS_201, AccountConstants.MESSAGE_201));
    }

    @GetMapping(value="/fetch", produces="application/json")
    public ResponseEntity<CustomerDto> fetchAccountDetails(@RequestParam String mobileNumber)
    {
        CustomerDto customerDto =  accountserviceImp.fetchAccount(mobileNumber);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(customerDto);
    }

    @PutMapping(value="/update", consumes="application/json")
    public ResponseEntity<ResponseDto> updateAccountDetails(@RequestBody CustomerDto customerDto)
    {
        boolean isUpdated = accountserviceImp.updateAccount(customerDto);
        if(isUpdated)
        {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(AccountConstants.STATUS_200, AccountConstants.MESSAGE_200));
        }
        else
        {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto(AccountConstants.STATUS_500, AccountConstants.STATUS_500));
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleleAccountDetails(@RequestParam String mobileNumber)
    {
        System.out.print("in controller"+mobileNumber);
        boolean isDeleted = accountserviceImp.deleteAccount(mobileNumber);
        if(isDeleted)
        {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(AccountConstants.STATUS_200, AccountConstants.MESSAGE_200));
        }
        else
        {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto(AccountConstants.STATUS_500, AccountConstants.STATUS_500));
        }
    }
}
