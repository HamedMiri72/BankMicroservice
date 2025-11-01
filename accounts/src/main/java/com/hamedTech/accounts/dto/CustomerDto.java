package com.hamedTech.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Singular;

@Data
@Schema(
        name = "customer",
        description = "Schema to hold customer information"
)
public class CustomerDto {


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
}
