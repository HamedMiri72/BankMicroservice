package com.hamedTech.accounts.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Singular;

@Data
public class CustomerDto {


    @NotEmpty(message = "Name can not be null or empty")
    @Size(min = 5, max = 30, message = "name should be between 5 to 30 letters")
    private String name;

    @NotEmpty(message = "Email can not be null or empty")
    @Email(message = "Email should have a valid format")
    private String email;

    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number should be 10 digits")
    private String mobileNumber;
    private AccountsDto accountsDto;
}
