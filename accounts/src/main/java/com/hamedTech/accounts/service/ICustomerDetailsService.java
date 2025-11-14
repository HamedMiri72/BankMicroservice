package com.hamedTech.accounts.service;

import com.hamedTech.accounts.dto.CustomerDetailsDto;

public interface ICustomerDetailsService {


    /**
     *
     * @param mobileNumber
     * @return
     */
    CustomerDetailsDto fetchCustomerDetails(String mobileNumber);
}
