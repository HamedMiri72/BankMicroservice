package com.hamedTech.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(
        name = "accounts",
        description = "Schema to hold account information"
)
public class AccountsDto {

    @Pattern(regexp = "(^$[0-9]{10})", message = "account number should be 10 digits")
    @NotEmpty(message = "account can not be null or empty")
    @Schema(
            description = "Account number of Bank account"
    )
    private Long accountNumber;

    @Schema(
            description = "Account type of Bank account", example = "Savings"
    )
    @NotEmpty(message = "account type can not be null or empty")
    private String accountType;

    @Schema(
            description = "Branch address of Bank account", example = "123 Main St, Anytown, USA"
    )
    @NotEmpty(message = "branch address can not be null or empty")
    private String branchAddress;
}
