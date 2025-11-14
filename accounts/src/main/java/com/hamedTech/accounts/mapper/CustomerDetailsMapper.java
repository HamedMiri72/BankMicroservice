package com.hamedTech.accounts.mapper;

import com.hamedTech.accounts.dto.CustomerDetailsDto;
import com.hamedTech.accounts.entity.Customer;

public class CustomerDetailsMapper {

    public static CustomerDetailsDto mapToCustomerDetailsDto(Customer customer, CustomerDetailsDto customerDetailsDto){

        customerDetailsDto.setName(customer.getName());
        customerDetailsDto.setEmail(customer.getEmail());
        customerDetailsDto.setMobileNumber(customer.getMobileNumber());


        return customerDetailsDto;
    }
}
