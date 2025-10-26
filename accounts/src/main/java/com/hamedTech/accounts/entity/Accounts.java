package com.hamedTech.accounts.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Accounts extends BaseEntity{

    @Id
    /**
     * We don't mention account number generated value since we want to have a small logic
     * inside the rest APIs to generate it based on specific logic.
     *
     */
    @Column(name = "account_number")
    private Long accountNumber;

    private Long customerId;

    private String accountType;

    private String branchAddress;
}
