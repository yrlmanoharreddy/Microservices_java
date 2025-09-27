package com.manuBank.accounts.controller;

import com.manuBank.accounts.constants.AccountConstants;
import com.manuBank.accounts.dto.AccountsDto;
import com.manuBank.accounts.dto.CustomerDto;
import com.manuBank.accounts.dto.ResponseDto;
import com.manuBank.accounts.service.impl.AccountServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api", consumes="application/json")
public class AccountsController {

    private AccountServiceImpl accountserviceImp;

    public AccountsController(AccountServiceImpl accountserviceImp) {
        this.accountserviceImp = accountserviceImp;
    }

    @PostMapping("create")
    public ResponseEntity<ResponseDto> createAccount(@RequestBody CustomerDto customerDto) {

        accountserviceImp.createAccount(customerDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountConstants.STATUS_201, AccountConstants.MESSAGE_201));
    }
}
