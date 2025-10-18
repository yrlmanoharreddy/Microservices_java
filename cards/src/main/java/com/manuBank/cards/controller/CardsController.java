package com.manuBank.cards.controller;

import com.manuBank.cards.dto.CardsDto;
import com.manuBank.cards.dto.ResponseDto;
import com.manuBank.cards.service.CardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cards")
public class CardsController {

    @Autowired
    public CardsService cardService;

    @PostMapping(value = "/create")
    public ResponseEntity<ResponseDto> createCard(@RequestParam String mobileNumber)
    {
        cardService.createCard(mobileNumber);
        ResponseDto responseDto = new ResponseDto();

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(responseDto);
    }
}
