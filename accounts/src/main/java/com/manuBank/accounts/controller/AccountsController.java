package com.manuBank.accounts.controller;

import com.manuBank.accounts.constants.AccountConstants;
import com.manuBank.accounts.dto.AccountsDto;
import com.manuBank.accounts.dto.CustomerDto;
import com.manuBank.accounts.dto.ErrorResponseDto;
import com.manuBank.accounts.dto.ResponseDto;
import com.manuBank.accounts.service.impl.AccountServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api")
@Validated
@Tag(
        name = "This controllers is used to create the bank accounts for the customer",
        description = "This controller is focusing on some main operations related to customer like " +
                "CRUD operation related to account to create the account, fetch the account details, updating the account details " +
                " and deleting the account details"
)
public class AccountsController {

    private AccountServiceImpl accountserviceImp;

    public AccountsController(AccountServiceImpl accountserviceImp) {
        this.accountserviceImp = accountserviceImp;
    }

    @PostMapping(value = "/create", consumes="application/json")
    @Operation(
            summary = "Creating the account for the customer",
            description = "It is the api endpoint for creating the account for the customer like C in CRUD"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description =" Http Status code for creating the account is 201"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Http Status code incase of any exception",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })

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
