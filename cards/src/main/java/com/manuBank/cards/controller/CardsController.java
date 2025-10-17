package com.manuBank.cards.controller;

import com.manuBank.cards.dto.CardsDto;
import com.manuBank.cards.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cards")
public class CardsController {

    @PostMapping(value = "/create")
    public ResponseEntity<ResponseDto> createCard(@RequestParam String mobileNumber)
    {

        ResponseDto responseDto = new ResponseDto();

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(responseDto);
    }
}
