package com.hamedTech.loans.controller;


import com.hamedTech.loans.dto.LoansDto;
import com.hamedTech.loans.dto.ResponseDto;
import com.hamedTech.loans.service.ILoansService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.aspectj.bridge.IMessage;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
public class LoansController {


    private final ILoansService loansService;


    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createLoan(@RequestBody
                                                      @Pattern(regexp = "^[0-9]{10}$", message = "Mobile Number should be 10 digits")
                                                      String mobileNumber){

        return null;
    }

    @GetMapping("/fetch")
    public ResponseEntity<LoansDto> fetchLoanDetails(@RequestParam
                                                     @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number should be 10 digits.")
                                                     String mobileNumber){
        return null;
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateLoanDetails(@Valid @RequestBody LoansDto loansDto){

        return null;

    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteLoanDetails(@RequestParam
                                                         @Pattern(regexp = "^[0-9]{10}$", message = "Mobile Number should be 10 digits")
                                                         String MobileNumber){
        return null;
    }


}
