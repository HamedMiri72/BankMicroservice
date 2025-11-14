package com.hamedTech.accounts.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(
        name = "LoansDto",
        description = "Schema to hold loans information")
public class LoansDto {

    @NotEmpty(message = "MobileNumber should not be empty or null")
    @Pattern(regexp = "^[0-9]{10}$", message = "MobileNumber should be 10 digits")
    @Schema(
            description = "Mobile Number of the customer",
            example = "1234567890"
    )
    private String mobileNumber;


    @NotEmpty(message = "loanNumber should noy be empty")
    @Pattern(regexp = "^[0-9]{12}$", message = "Loan number should be 12 digits")
    @Schema(
            description = "Loan Number of the customer",
            example = "123456789012"
    )
    private String LoanNumber;

    @NotEmpty(message = "loan type should not be empty or null")
    @Schema(
            description = "Loan type of the customer",
            example = "Personal Loan"
    )
    private String loanType;

    @PositiveOrZero(message = "total loan should be equal or grater than zero")
    @Schema(
            description = "Total loan of the customer",
            example = "10000"
    )
    private int totalLoan;


    @PositiveOrZero(message = "amount paid should be equal or grater than zero")
    @Schema(
            description = "Amount paid of the customer",
            example = "1000"
    )
    private int amountPaid;

    @Positive(message = "outstanding amount should be equal or grater than zero")
    @Schema(
            description = "Outstanding amount of the customer",
            example = "1000"
    )
    private int outstandingAmount;
}
