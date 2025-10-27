package com.hamedTech.accounts.service.impl;

import com.hamedTech.accounts.dto.CustomerDto;
import com.hamedTech.accounts.repository.AccountRepository;
import com.hamedTech.accounts.repository.CustomerRepository;
import com.hamedTech.accounts.service.IAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountsServiceImpl implements IAccountService {


    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;

    /**
     * create account
     * @param customerDto
     */
    @Override
    public void createAccounts(CustomerDto customerDto) {

    }
}
