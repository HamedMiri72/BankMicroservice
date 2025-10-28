package com.hamedTech.accounts.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AccountsDto {

    @Pattern(regexp = "(^$[0-9]{10})", message = "account number should be 10 digits")
    @NotEmpty(message = "account can not be null or empty")
    private Long accountNumber;

    @NotEmpty(message = "account type can not be null or empty")
    private String accountType;

    @NotEmpty(message = "branch address can not be null or empty")
    private String branchAddress;
}
