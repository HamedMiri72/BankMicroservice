package com.hamedTech.accounts.controller;


import com.hamedTech.accounts.dto.CustomerDetailsDto;
import com.hamedTech.accounts.service.ICustomerDetailsService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
@Tag(
        name = "Customer Details",
        description = "Customer Details REST APIs"
)
public class CustomerDetailsController {

    private final ICustomerDetailsService service;


    @GetMapping("/fetchCustomerDetails")
    public ResponseEntity<CustomerDetailsDto> fetchCustomerDetails(@RequestParam
                                                                    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number should be 10 digits")
                                                                       String mobileNumber){

        CustomerDetailsDto customerDetailsDto = service.fetchCustomerDetails(mobileNumber);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(customerDetailsDto);

    }


}
