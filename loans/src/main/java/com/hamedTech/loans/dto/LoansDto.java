package com.hamedTech.loans.dto;


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
public class LoansDto {

    @NotEmpty(message = "MobileNumber should not be empty or null")
    @Pattern(regexp = "^[0-9]{10}$", message = "MobileNumber should be 10 digits")
    private String mobileNumber;


    @NotEmpty(message = "loanNumber should noy be empty")
    @Pattern(regexp = "^[0-9]{12}$", message = "Loan number should be 12 digits")
    private String LoanNumber;

    @NotEmpty(message = "loan type should not be empty or null")
    private String loanType;

    @PositiveOrZero(message = "total loan should be equal or grater than zero")
    private int totalLoan;


    @PositiveOrZero(message = "amount paid should be equal or grater than zero")
    private int amountPaid;

    @Positive(message = "outstanding amount should be equal or grater than zero")
    private int outstandingAmount;
}
