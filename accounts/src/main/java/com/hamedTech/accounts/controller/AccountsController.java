package com.hamedTech.accounts.controller;

import com.hamedTech.accounts.constants.AccountsConstants;
import com.hamedTech.accounts.dto.CustomerDto;
import com.hamedTech.accounts.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountsController {


    @PostMapping
    public ResponseEntity<ResponseDto> createAccount(@RequestBody CustomerDto request){


        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountsConstants.STATUS_201, AccountsConstants.MESSAGE_201));
    }

}
