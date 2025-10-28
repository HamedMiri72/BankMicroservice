package com.hamedTech.accounts.mapper;

import com.hamedTech.accounts.dto.AccountsDto;
import com.hamedTech.accounts.entity.Accounts;

public class AccountsMapper {

    public static AccountsDto mapToDto(Accounts accounts, AccountsDto accountsDto){

        accountsDto.setAccountNumber(accounts.getAccountNumber());
        accountsDto.setAccountType(accounts.getAccountType());
        accountsDto.setBranchAddress(accounts.getBranchAddress());

        return accountsDto;

    }


    public static Accounts mapToEntity(AccountsDto accountsDto, Accounts accounts){

        accounts.setAccountNumber(accountsDto.getAccountNumber());
        accounts.setAccountType(accountsDto.getAccountType());
        accounts.setBranchAddress(accountsDto.getBranchAddress());

        return accounts;
    }

}
