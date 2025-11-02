package com.hamedTech.loans.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class LoansAlreadyExists extends RuntimeException{

    public LoansAlreadyExists(String msg){
        super(msg);
    }


}
