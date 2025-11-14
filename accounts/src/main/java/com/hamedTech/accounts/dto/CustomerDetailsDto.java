package com.hamedTech.accounts.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(
        name = "CustomerDetailsDto",
        description = "Schema to hold customer details"
)
@Data
public class CustomerDetailsDto {


    @NotEmpty(message = "Name can not be null or empty")
    @Size(min = 5, max = 30, message = "name should be between 5 to 30 letters")
    @Schema(
            description = "Name of customer",
            example = "John Doe"
    )
    private String name;

    @NotEmpty(message = "Email can not be null or empty")
    @Email(message = "Email should have a valid format")
    @Schema(
            description = "Email of customer",
            example = "john.doe@example.com"
    )
    private String email;

    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number should be 10 digits")
    @Schema(
            description = "Mobile number of customer",
            example = "7355848222"
    )
    private String mobileNumber;
    @Schema(
            description = "Accounts details of customer"
    )
    private AccountsDto accountsDto;

    @Schema(
            description = "cards details of customer"
    )
    private CardDto cardDto;

    @Schema(
            description = "loans details of customer"
    )
    private LoansDto loansDto;
}
