package com.hamedTech.accounts.service;

import com.hamedTech.accounts.dto.CustomerDto;

public interface IAccountService {


    /**
     * create account
     * @param customerDto
     */
    void createAccounts(CustomerDto customerDto);

    /**
     *
     * @param mobileNumber
     * @return
     */
    CustomerDto fetchAccount(String mobileNumber);
}
